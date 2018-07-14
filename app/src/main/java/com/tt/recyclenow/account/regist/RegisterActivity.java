package com.tt.recyclenow.account.regist;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.base.TBaseActivity;
import com.hzecool.widget.ClearableEditText;
import com.hzecool.widget.CountDownButton.CountDownButton;
import com.tt.recyclenow.R;
import com.tt.recyclenow.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author tutu
 * @time 2018/6/12
 */
public class RegisterActivity extends TBaseActivity<IRegisterView, RegisterPresenter>
        implements IRegisterView {
    @BindView(R.id.edt_loginName)
    ClearableEditText edtLoginName;
    @BindView(R.id.edt_code)
    ClearableEditText edtCode;
    @BindView(R.id.btn_getcode)
    CountDownButton btnGetcode;
    @BindView(R.id.edt_psw)
    ClearableEditText edtPsw;
    @BindView(R.id.tv_login)
    CheckedTextView tvLogin;

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
        return R.layout.regist_layout;
    }

    @Override
    public void initView() {
        edtLoginName.addTextChangedListener(textWatcher);
        edtPsw.addTextChangedListener(textWatcher);
        tvLogin.addTextChangedListener(textWatcher);
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        llBack.setVisibility(View.GONE);
        titleName.setText("注册");
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @OnClick({R.id.btn_getcode, R.id.tv_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_getcode:
                mPresenter.getCode();
                btnGetcode.start();
                break;
            case R.id.tv_login:
                onRegister();
                break;
            default:
                break;
        }
    }

    private void onRegister() {
        if (checkRight()) {
            mPresenter.register();
        } else {
            ToastUtils.showShortToast("请输入完整");
        }
    }


    private boolean checkRight() {
        if (TextUtils.isEmpty(edtLoginName.getText().toString().trim()) ||
                TextUtils.isEmpty(edtCode.getText().toString().trim()) ||
                TextUtils.isEmpty(edtPsw.getText().toString().trim()) ||
                edtCode.getText().toString().trim().length() != 5 ||
                edtPsw.getText().toString().trim().length() < 6
                ) {
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

    @Override
    public String getCode() {
        return edtCode.getText().toString().trim();
    }

    @Override
    public String getPhone() {
        return edtLoginName.getText().toString().trim();
    }

    @Override
    public String getPsw() {
        return edtPsw.getText().toString().trim();
    }

    @Override
    public void registOk() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void getCodeOk() {

    }
}
