package com.tt.recyclenow.auth.main;

import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseActivity;
import com.megvii.faceid.zzplatform.sdk.config.UserConfig;
import com.megvii.faceid.zzplatform.sdk.listener.AccessCallBackListener;
import com.megvii.faceid.zzplatform.sdk.manager.FaceppManager;
import com.megvii.faceid.zzplatform.sdk.manager.MegLiveDetectListener;
import com.megvii.faceid.zzplatform.sdk.manager.MegLiveRecordVideoListener;
import com.megvii.faceidiol.sdk.manager.IDCardDetectListener;
import com.megvii.faceidiol.sdk.manager.IDCardManager;
import com.megvii.faceidiol.sdk.manager.IDCardResult;
import com.tt.recyclenow.R;
import com.tt.recyclenow.auth.GenerateSign;

import java.io.ByteArrayOutputStream;

import butterknife.OnClick;

/**
 * @author tutu
 * @time 2018/6/7
 */

public class AuthActivity extends TBaseActivity<IAuthView, AuthPresenter>
        implements IAuthView, IDCardDetectListener, MegLiveDetectListener, MegLiveRecordVideoListener {
    private long mDoubleClickTime = 0L;
    private static final String apiKey = "PVrbAEaNsjCXd-ImwrlKReFiaVWBsKed";
    private static final String secret = "zUK5XVzHqjDUOtlaTxitb5u8iOEB_Qzb";


    /**
     * 活体检测人用户的名字,身份证号码
     */
    private String mName;
    private String mNum;

    @Override
    public int getLayoutID() {
        return R.layout.auth_activity_layout;
    }

    @Override
    public void initView() {
        IDCardManager.getInstance().setIdCardDetectListener(AuthActivity.this);
        FaceppManager.getInstance(this).setMegLiveDetectListener(this);
        FaceppManager.getInstance(this).setMegLiveRecordVideoListener(this);
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("认证中心");
    }

    @Override
    protected AuthPresenter createPresenter() {
        return new AuthPresenter();
    }

    @Override
    public void onLoadData(Object o) {

    }

    @Override
    public void onEmptyData() {

    }

    @Override
    public void onLoadError(String msg) {

    }

    @Override
    public void onNetError(String msg) {

    }

    @OnClick({R.id.rl1, R.id.rl2, R.id.rl3, R.id.rl4, R.id.rl5, R.id.rl6, R.id.rl7, R.id.ctv_next})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl1:
                idCardAuth();
                break;
            case R.id.rl2:
                break;
            case R.id.rl3:
                break;
            case R.id.rl4:
                break;
            case R.id.rl5:
                break;
            case R.id.rl6:
                break;
            case R.id.rl7:
                break;
            default:
                break;
        }
    }

    /**
     * 实名认证 (身份证识别)
     */
    private void idCardAuth() {
        new Thread(() -> {

            long currtTime = System.currentTimeMillis() / 1000;
            long expireTime = System.currentTimeMillis() / 1000 + 60 * 60 * 24;
            String sign = GenerateSign.appSign(apiKey, secret, currtTime, expireTime);
            IDCardManager.getInstance().init(AuthActivity.this, sign, "hmac_sha1", new IDCardManager.InitCallBack() {
                @Override
                public void initSuccess(String bizToken) {
                    IDCardManager.getInstance().startDetect(AuthActivity.this, bizToken, "");
                }

                @Override
                public void initFailed(int resultCode, String resultMessage) {
                    showAlertDlg("提示", resultMessage);
                }
            });
        }).start();
    }

    @Override
    public void onIdCardDetectFinish(IDCardResult result) {
        /**
         * 身份证识别回调
         */
        if (result.getResultCode() == 1001 || result.getResultCode() == 1002) {
//            Intent intent = new Intent(this, ResultActivity.class);
//            intent.putExtra("faceImg", result.getIdCardInfo().getImageFrontside());
//            intent.putExtra("portraitImg", result.getIdCardInfo().getImagePortrait());
//            intent.putExtra("emblemImg", result.getIdCardInfo().getImageBackside());
//            intent.putExtra("name",result.getIdCardInfo().getName().getText());
//            intent.putExtra("idcardNum",result.getIdCardInfo().getIdcardNumber().getText());
//            intent.putExtra("dateBegin",result.getIdCardInfo().getValidDateStart().getText());
//            intent.putExtra("dateEnd",result.getIdCardInfo().getValidDateEnd().getText());
//            startActivity(intent);
            mName = result.getIdCardInfo().getName().getText();
            mNum = result.getIdCardInfo().getIdcardNumber().getText();

            imgBodyAuth();
        } else {
            showAlertDlg("提示", result.getResultMessage());
        }
    }

    /**
     * 活体检测人脸对比
     */
    private void imgBodyAuth() {
        if (System.currentTimeMillis() - mDoubleClickTime < 2000L) {
            return;
        }
        mDoubleClickTime = System.currentTimeMillis();
        showLoadingDialog(true, false, "初始化中...");

        long currtTime = System.currentTimeMillis() / 1000;
        long expireTime = (System.currentTimeMillis() + 60 * 60 * 100) / 1000;
        String sign = GenerateSign.appSign(apiKey, secret, currtTime, expireTime);
        sign = sign.replaceAll("[\\s*\t\n\r]", "");

        String signVersion = "hmac_sha1";
        UserConfig userConfig = new UserConfig();
        userConfig.setIdcardName(mName);
        userConfig.setIdcardNumber(mNum);
        FaceppManager.getInstance(AuthActivity.this).init(sign, signVersion, userConfig, new AccessCallBackListener() {
            @Override
            public void onSuccess(String responseBody) {
                FaceppManager.getInstance(AuthActivity.this).startDetect();
                cancelLoadingDialog();
            }

            @Override
            public void onFailure(int statusCode) {
                cancelLoadingDialog();
                showAlertDlg("提示", statusCode + "");
            }
        });
    }

    @Override
    public void onCallback(int i, String s) {
        /**
         * 活体检测人脸对比结果
         */
        if (i == 1000) {
            /**
             * 同一个人
             */
        } else if (i == 2000) {
            /**
             * 不是同一个人
             */
        } else {
            showAlertDlg("提示", s);
        }
    }

    @Override
    public void onRecordVideoFinish(String videoPath) {
        /**
         * 活体检测人脸对比 视频地址
         */
    }
}
