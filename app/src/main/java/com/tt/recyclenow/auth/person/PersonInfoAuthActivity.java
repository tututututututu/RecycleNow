package com.tt.recyclenow.auth.person;

import android.Manifest;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hzecool.common.utils.Utils;
import com.hzecool.core.base.TBaseActivity;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.tt.recyclenow.R;

/**
 * Created by tu on 2018/7/18.
 */

public class PersonInfoAuthActivity extends TBaseActivity<IPersonInfoAuth,PersonInfoAuthPresenter>
    implements IPersonInfoAuth{
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
        return R.layout.person_info_activity_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected PersonInfoAuthPresenter createPresenter() {
        return new PersonInfoAuthPresenter();
    }


    /**
     * 通讯录认证
     * @param card
     */
    public void requestPermissionContact(final String card) {
        RxPermissions rxPermissions = new RxPermissions(this);

        rxPermissions.request(
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        mPresenter.getContacts();
                    } else {
                        Toast.makeText(Utils.getContext(), "没有获取到需要的权限", Toast.LENGTH_SHORT).show();

                    }
                });

    }
}
