package com.tt.recyclenow.auth.idcard;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.hzecool.common.utils.HandlerUtil;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.common.utils.Utils;
import com.hzecool.core.base.TBaseActivity;
import com.megvii.faceid.zzplatform.sdk.config.UserConfig;
import com.megvii.faceid.zzplatform.sdk.listener.AccessCallBackListener;
import com.megvii.faceid.zzplatform.sdk.manager.FaceppManager;
import com.megvii.faceid.zzplatform.sdk.manager.MegLiveDetectListener;
import com.megvii.faceid.zzplatform.sdk.manager.MegLiveRecordVideoListener;
import com.megvii.faceidiol.sdk.manager.IDCardDetectListener;
import com.megvii.faceidiol.sdk.manager.IDCardManager;
import com.megvii.faceidiol.sdk.manager.IDCardResult;
import com.megvii.faceidiol.sdk.manager.UserDetectConfig;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.tt.recyclenow.R;
import com.tt.recyclenow.auth.GenerateSign;
import com.tt.recyclenow.bean.SFZFMBean;
import com.tt.recyclenow.bean.SFZMBean;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author tutu
 * @time 2018/6/9
 */

public class IDCardActivity extends TBaseActivity<IIDCardView, IDCardPresenter>
        implements IIDCardView, IDCardDetectListener, MegLiveDetectListener, MegLiveRecordVideoListener {
    @BindView(R.id.rl_img)
    RelativeLayout rlImg;
    @BindView(R.id.rl_img1)
    RelativeLayout rlImg1;
    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.et_bank)
    EditText etBank;
    @BindView(R.id.et_id)
    EditText etID;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.iv_sfzFm)
    ImageView ivSfzFm;
    @BindView(R.id.iv_sfzZm)
    ImageView ivSfzZm;

    private static final String apiKey = "PVrbAEaNsjCXd-ImwrlKReFiaVWBsKed";
    private static final String secret = "zUK5XVzHqjDUOtlaTxitb5u8iOEB_Qzb";

    private UserDetectConfig config = new UserDetectConfig();
    private String mName;
    private String mNum;
    private long mDoubleClickTime = 0L;

    /**
     * 身份证的识别结果
     */
    private IDCardResult sfzResult;

    @Override
    public void onLoadData(Object o) {

    }

    @Override
    public void onEmptyData() {

    }

    @Override
    public void onLoadError(String msg) {
        showAlertDlg("提示", msg);
        cancelLoadingDialog();
    }

    @Override
    public void onNetError(String msg) {

    }

    @Override
    public int getLayoutID() {
        return R.layout.id_card_activity_layout;
    }

    @Override
    public void initView() {
        config.setCaptureImage(0);
        config.setScreenDirection(0);
        IDCardManager.getInstance().setIdCardDetectListener(this);
        FaceppManager.getInstance(this).setMegLiveDetectListener(this);
        FaceppManager.getInstance(this).setMegLiveRecordVideoListener(this);
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("实名认证");
    }

    @Override
    protected IDCardPresenter createPresenter() {
        return new IDCardPresenter();
    }


    @OnClick({R.id.rl_img, R.id.rl_img1, R.id.tv_start})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_img:
            case R.id.rl_img1:
                RxPermissions rxPermissions = new RxPermissions(this);

                rxPermissions.request(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA
                )
                        .subscribe(aBoolean -> {
                            if (aBoolean) {
                                try {
                                    startSFZAuth();
                                }catch (Exception e){
                                    ToastUtils.showShortToast(e.getMessage());
                                }

                            } else {
                                Toast.makeText(Utils.getContext(), "没有获取到需要的权限", Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            case R.id.tv_start:
                if (TextUtils.isEmpty(etBank.getText().toString().trim())) {
                    ToastUtils.showShortToast("请填写银行卡号");
                } else {
                    imgBodyAuth();
                }
                break;
            default:
                break;
        }
    }

    private void startSFZAuth() {
        new Thread(() -> {
            long currtTime = System.currentTimeMillis() / 1000;
            long expireTime = System.currentTimeMillis() / 1000 + 60 * 60 * 24;
            String sign = GenerateSign.appSign(apiKey, secret, currtTime, expireTime);
            IDCardManager.getInstance().init(IDCardActivity.this, sign, "hmac_sha1", config, new IDCardManager.InitCallBack() {
                @Override
                public void initSuccess(String bizToken) {
                    IDCardManager.getInstance().startDetect(IDCardActivity.this, bizToken, "");
                }

                @Override
                public void initFailed(int resultCode, String resultMessage) {
                    HandlerUtil.post(new Runnable() {
                        @Override
                        public void run() {
                            showAlertDlg("提示", resultMessage);
                        }
                    });

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

            sfzResult = result;
//            Intent intent = new Intent(this, ResultActivity.class);
//            intent.putExtra("faceImg", result.getIdCardInfo().getImageFrontside());
//            intent.putExtra("portraitImg", result.getIdCardInfo().getImagePortrait());
//            intent.putExtra("emblemImg", result.getIdCardInfo().getImageBackside());
//            intent.putExtra("name",result.getIdCardInfo().getName().getText());
//            intent.putExtra("idcardNum",result.getIdCardInfo().getIdca nrdNumber().getText());
//            intent.putExtra("dateBegin",result.getIdCardInfo().getValidDateStart().getText());
//            intent.putExtra("dateEnd",result.getIdCardInfo().getValidDateEnd().getText());
//            startActivity(intent);

            Bitmap front = BitmapFactory.decodeByteArray(result.getIdCardInfo().getImageFrontside(), 0, result.getIdCardInfo().getImageFrontside().length);
            Bitmap back = BitmapFactory.decodeByteArray(result.getIdCardInfo().getImageBackside(), 0, result.getIdCardInfo().getImageBackside().length);

            ivSfzZm.setImageBitmap(front);
            ivSfzFm.setImageBitmap(back);

            mName = result.getIdCardInfo().getName().getText();
            mNum = result.getIdCardInfo().getIdcardNumber().getText();
            etID.setText(result.getIdCardInfo().getIdcardNumber().getText());
            etName.setText(result.getIdCardInfo().getName().getText());
        } else {
            showAlertDlg("提示", result.getResultMessage());
            sfzResult = null;
        }
    }

    /**
     * 活体检测人脸对比
     */
    private void imgBodyAuth() {
        if (sfzResult == null) {
            ToastUtils.showShortToast("请先上传身份证");
            return;
        }

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
        FaceppManager.getInstance(IDCardActivity.this).init(sign, signVersion, userConfig, new AccessCallBackListener() {
            @Override
            public void onSuccess(String responseBody) {
                FaceppManager.getInstance(IDCardActivity.this).startDetect();
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
            Map<String, String> params = new HashMap<>();

            SFZFMBean sfzfmBean = new SFZFMBean();
            sfzfmBean.setValid_date(sfzResult.getIdCardInfo().getValidDateStart().getText() + "-" + sfzResult.getIdCardInfo().getValidDateEnd().getText());
            sfzfmBean.setIssued_by(sfzResult.getIdCardInfo().getIssuedBy().getText());

            SFZMBean sfzmBean = new SFZMBean();
            sfzmBean.setAddress(sfzResult.getIdCardInfo().getAddress().getText());
            sfzmBean.setGender(sfzResult.getIdCardInfo().getGender().getText());
            sfzmBean.setId_card_number(sfzResult.getIdCardInfo().getIdcardNumber().getText());
            sfzmBean.setRace(sfzResult.getIdCardInfo().getNationality().getText());


            params.put("sfzzmImg", GenerateSign.Base64Encode(sfzResult.getIdCardInfo().getImageFrontside()));
            params.put("sfzfmImg", GenerateSign.Base64Encode(sfzResult.getIdCardInfo().getImageBackside()));
            params.put("name", mName);
            params.put("sfzhm", mNum);
            params.put("bankcard", etBank.getText().toString().trim());
            params.put("zmcards", JSON.toJSONString(sfzmBean));
            params.put("fmcards", JSON.toJSONString(sfzfmBean));

            showLoadingDialog(false, false, "识别中..");
            mPresenter.smAuth(params);
        } else if (i == 2000) {
            /**
             * 不是同一个人
             */
            showAlertDlg("校验失败,人脸识别和身份证不是同一个人,请重新检测", s);
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

    @Override
    public void onAuthOk() {
        cancelLoadingDialog();
        ToastUtils.showShortToast("实名认证成功");
        finish();
    }
}
