package com.tt.recyclenow.account.cpw;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;

/**
 * Created by tu on 2018/6/9.
 */

public class ChangePswActivity extends TBaseActivity<IChangePswView, ChangePswPresenter>
        implements IChangePswView {
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
        return R.layout.cpw_activity;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected ChangePswPresenter createPresenter() {
        return new ChangePswPresenter();
    }
}
