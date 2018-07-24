package com.tt.recyclenow.mine;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.base.TBaseFragment;
import com.qihoo.appstore.common.updatesdk.lib.UpdateHelper;
import com.tt.recyclenow.R;
import com.tt.recyclenow.account.login.LoginActivity;
import com.tt.recyclenow.account.setting.AccountSettingActivity;
import com.tt.recyclenow.app.Constants;
import com.tt.recyclenow.auth.bank.BankActivity;
import com.tt.recyclenow.bean.ContatcUsBean;
import com.tt.recyclenow.main.TextActivity;
import com.tt.recyclenow.mine.guide.HelpActivity;
import com.tt.recyclenow.recycleHistory.HistoryActivity;

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
    @BindView(R.id.tv_name)
    TextView tvName;

    private ContatcUsBean bean;

    @Override
    public int getLayoutID() {
        return R.layout.mine_fragment_layout;
    }

    @Override
    public void initView() {
        if (!TextUtils.isEmpty(SPUtils.getString(Constants.SP_USER_NAME))) {
            tvName.setText(SPUtils.getString(Constants.SP_USER_NAME));
        } else {
            tvName.setText("请登录");
        }
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("我的");
        llBack.setVisibility(View.GONE);
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }

    @Override
    public void onLoadData(Object o) {
        bean = (ContatcUsBean) o;
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

    @Override
    public void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(SPUtils.getString(Constants.SP_USER_NAME))) {
            tvName.setText(SPUtils.getString(Constants.SP_USER_NAME));
        } else {
            tvName.setText("请登录");
        }
    }

    @OnClick({R.id.rl1, R.id.rl2, R.id.rl3, R.id.rl4, R.id.rl_history, R.id.rl_bank, R.id.ll_info})
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.rl1:

                if (TextUtils.isEmpty(SPUtils.getString(Constants.SP_TOKENDS))) {
                    intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                } else {
                    intent = new Intent(getActivity(), AccountSettingActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.rl2:
                intent = new Intent(getActivity(), TextActivity.class);
                intent.putExtra("text", bean.getData().getLxfknr());
                startActivity(intent);

                break;
            case R.id.rl3:
                intent = new Intent(getActivity(), HelpActivity.class);
                startActivity(intent);
                break;
            case R.id.rl4:
                requestUpdate();
                break;
            case R.id.rl_history:
                intent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_bank:
                intent = new Intent(getActivity(), BankActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_info:
                if (TextUtils.isEmpty(SPUtils.getString(Constants.SP_TOKENDS))) {
                    intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
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
        UpdateHelper.getInstance().init(getActivity().getApplicationContext(), getResources().getColor(R.color.main));
        UpdateHelper.getInstance().manualUpdate("com.tt.recyclenow");
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
