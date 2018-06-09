package com.tt.recyclenow.mine;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hzecool.core.activity.webview.JsBridgeWebViewActivity;
import com.hzecool.core.base.TBaseFragment;
import com.tt.recyclenow.R;
import com.tt.recyclenow.account.setting.AccountSettingActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author tutu
 * @time 2018/6/9
 */

public class MineFragment extends TBaseFragment<IMineView, MinePresenter>
        implements IMineView {


    @BindView(R.id.civ)
    ImageView civ;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.rl1)
    RelativeLayout rl1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.rl2)
    RelativeLayout rl2;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.rl3)
    RelativeLayout rl3;
    @BindView(R.id.iv4)
    ImageView iv4;
    @BindView(R.id.rl4)
    RelativeLayout rl4;

    @Override
    public int getLayoutID() {
        return R.layout.mine_fragment_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
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

    @OnClick({R.id.rl1, R.id.rl2, R.id.rl3, R.id.rl4})
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.rl1:
                intent = new Intent(getActivity(), AccountSettingActivity.class);
                startActivity(intent);
                break;
            case R.id.rl2:
                /**
                 * 跳转QQ对话
                 */
                openQQ();
                break;
            case R.id.rl3:
                intent = new Intent(getActivity(), JsBridgeWebViewActivity.class);
                startActivity(intent);
                break;
            case R.id.rl4:
                requestUpdate();
                break;
            default:
                break;
        }
    }

    private void openQQ() {
        if (checkApkExist(getActivity().getApplicationContext(), "com.tencent.mobileqq")) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=" + 470666774 + "&version=1")));
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "本机未安装QQ应用", Toast.LENGTH_SHORT).show();
        }
    }

    private void requestUpdate() {
        /**
         * 版本更新
         */
    }

    public boolean checkApkExist(Context context, String packageName) {
        if (packageName == null || "".equals(packageName)) {
            return false;
        }
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName,
                    PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
