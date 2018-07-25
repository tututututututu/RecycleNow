package com.tt.recyclenow.account.cpw;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.common.utils.SPUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.base.TBaseActivity;
import com.hzecool.widget.ClearableEditText;
import com.hzecool.widget.CountDownButton.CountDownButton;
import com.tt.recyclenow.R;
import com.tt.recyclenow.account.login.LoginActivity;
import com.tt.recyclenow.app.Constants;

import butterknife.BindView;

/**
 * Created by tu on 2018/6/9.
 */

public class ChangePswActivity extends TBaseActivity<IChangePswView, ChangePswPresenter>
        implements IChangePswView {
    @BindView(R.id.edt_loginName)
    ClearableEditText edtLoginName;
    @BindView(R.id.edt_code)
    EditText edtCode;
    @BindView(R.id.btn_getcode)
    CountDownButton btnGetcode;
    @BindView(R.id.edt_psw)
    ClearableEditText edtPsw;
    @BindView(R.id.tv_login)
    CheckedTextView tvLogin;

    @Override
    public void onLoadData(Object o) {
        ToastUtils.showShortToast("修改成功,请重新登录");
        SPUtils.putString(Constants.SP_TOKENDS, "");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onEmptyData() {

    }

    @Override
    public void onLoadError(String msg) {
        showAlertDlg("提示", msg);
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
            edtCode.setText(userName);
        }

        edtLoginName.addTextChangedListener(watcher);
        edtPsw.addTextChangedListener(watcher);

        tvLogin.setOnClickListener(view -> mPresenter.change(edtLoginName.getText().toString().trim(), edtPsw.getText().toString().trim()));
        btnGetcode.setOnClickListener(view -> {

            mPresenter.getCode(userName);
            btnGetcode.start();
        });

    }


    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(edtLoginName.getText().toString().trim()) ||
                    TextUtils.isEmpty(edtPsw.getText().toString().trim())) {
                tvLogin.setChecked(false);
            } else {
                tvLogin.setChecked(true);
            }
        }
    };

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("修改密码");
    }

    @Override
    protected ChangePswPresenter createPresenter() {
        return new ChangePswPresenter();
    }
}
