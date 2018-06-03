package com.tt.recyclenow.check;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.common.utils.DeviceUtils;
import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;

import at.grabner.circleprogress.CircleProgressView;
import butterknife.BindView;

/**
 * Created by tu on 2018/6/3.
 */

public class CheckPhoneActivity extends TBaseActivity<ICheckPhoneView, CheckPhonePresenter>
        implements ICheckPhoneView {
    @BindView(R.id.circleView)
    CircleProgressView circleView;
    @BindView(R.id.tv_info)
    TextView tvInfo;

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
        return R.layout.check_phone_activity_layout;
    }

    @Override
    public void initView() {
        String cs = DeviceUtils.getManufacturer();
        String xh = DeviceUtils.getModel();
        String store = String.valueOf(DeviceUtils.getTotalInternalMemorySize());

        tvInfo.setText(cs+xh+"\n"+store);
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected CheckPhonePresenter createPresenter() {
        return new CheckPhonePresenter();
    }
}
