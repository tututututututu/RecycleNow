package com.tt.recyclenow.account.setting;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hzecool.common.utils.AppUtils;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.base.TBaseActivity;
import com.hzecool.core.manager.ActivityStack;
import com.tt.recyclenow.R;
import com.tt.recyclenow.account.cpw.ChangePswActivity;
import com.tt.recyclenow.account.login.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author tutu
 * @time 2018/6/9
 */

public class AccountSettingActivity extends TBaseActivity<IAccountSettingView, AccountSettingPresenter>
        implements IAccountSettingView {
    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.rl_change_psw)
    RelativeLayout rlChangePsw;
    @BindView(R.id.tv_logout)
    TextView tvLogout;

    @Override
    public void onLoadData(Object o) {
        SPUtils.clear();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        ActivityStack.finishAll();
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
    public int getLayoutID() {
        return R.layout.account_activity_layoout;
    }

    @Override
    public void initView() {
        tvVersion.setText("秒回收 " + AppUtils.getAppVersionName());
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("用户中心");
    }

    @Override
    protected AccountSettingPresenter createPresenter() {
        return new AccountSettingPresenter();
    }


    @OnClick({R.id.rl_change_psw, R.id.tv_logout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_change_psw:
                // TODO: 2018/7/14 清楚用户信息
                //SPOperation.clearSp();
                Intent intent1 = new Intent(this, ChangePswActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.tv_logout:
                mPresenter.logout();
                break;
            default:
                break;
        }
    }
}
