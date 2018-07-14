package com.tt.recyclenow.account.login;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseActivity;
import com.hzecool.widget.ClearableEditText;
import com.tt.recyclenow.R;
import com.tt.recyclenow.account.cpw.ChangePswActivity;
import com.tt.recyclenow.account.regist.RegisterActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tu on 2018/6/9.
 */

public class LoginActivity extends TBaseActivity<ILoginView, LoginPresenter>
        implements ILoginView {
    @BindView(R.id.edt_loginName)
    ClearableEditText edtLoginName;
    @BindView(R.id.edt_psw)
    ClearableEditText edtPsw;
    @BindView(R.id.tv_login)
    CheckedTextView tvLogin;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    @BindView(R.id.tv_register)
    TextView tvRegister;

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
        return R.layout.login_activity;
    }

    @Override
    public void initView() {
        edtLoginName.addTextChangedListener(textWatcher);
        edtPsw.addTextChangedListener(textWatcher);
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @OnClick({R.id.tv_login, R.id.tv_forget, R.id.tv_register})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.tv_login:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_forget:
                intent = new Intent(this, ChangePswActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_register:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        finish();
    }


    private boolean checkRight() {
        if (TextUtils.isEmpty(edtLoginName.getText().toString().trim()) ||
                TextUtils.isEmpty(edtPsw.getText().toString().trim())) {
            return false;
        }

        return true;
    }


    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (checkRight()) {
                tvLogin.setChecked(true);
                tvLogin.setEnabled(true);
            } else {
                tvLogin.setChecked(false);
                tvLogin.setEnabled(false);
            }
        }
    };
}