package com.tt.recyclenow.account.cpw;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;
import com.tt.recyclenow.app.Constants;

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
        String userName = SPUtils.getString(Constants.SP_USER_NAME);
        if (!TextUtils.isEmpty(userName)) {
            //edtLoginName.setText(userName);
        }
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected ChangePswPresenter createPresenter() {
        return new ChangePswPresenter();
    }
}
