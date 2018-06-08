package com.tt.recyclenow.bill;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;

/**
 * @author tutu
 * @time 2018/6/8
 */

public class BillActivity extends TBaseActivity<IBillView, BillPresenter>
        implements IBillView {
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
        return R.layout.bill_activity;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected BillPresenter createPresenter() {
        return new BillPresenter();
    }
}
