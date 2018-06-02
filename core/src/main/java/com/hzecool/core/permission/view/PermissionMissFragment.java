package com.hzecool.core.permission.view;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.R;
import com.hzecool.core.base.TBaseFragment;
import com.hzecool.core.base.TBasePresenter;

/**
 * @author 47066
 */
public class PermissionMissFragment extends TBaseFragment
        implements IPermissionMissView {

    @Override
    public int getLayoutID() {
        return R.layout.fragment_permission_miss;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        llBack.setVisibility(View.GONE);
        titleName.setText(R.string.access_forbiden);
    }

    @Override
    protected TBasePresenter createPresenter() {
        return new PermissionMissPresenter();
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
}
