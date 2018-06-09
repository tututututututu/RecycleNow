package com.tt.recyclenow.account;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseActivity;

/**
 * @author tutu
 * @time 2018/6/9
 */

public class AccountSettingActivity extends TBaseActivity<IAccountSettingView, AccountSettingPresenter>
        implements IAccountSettingView {
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

    @Override
    public int getLayoutID() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected AccountSettingPresenter createPresenter() {
        return new AccountSettingPresenter();
    }
}
