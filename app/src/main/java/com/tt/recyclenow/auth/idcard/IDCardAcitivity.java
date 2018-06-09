package com.tt.recyclenow.auth.idcard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;

/**
 * @author tutu
 * @time 2018/6/9
 */

public class IDCardAcitivity extends TBaseActivity<IIDCardView,IDCardPrensenter>
    implements IIDCardView{
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
        return R.layout.id_card_activity_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected IDCardPrensenter createPresenter() {
        return new IDCardPrensenter();
    }
}
