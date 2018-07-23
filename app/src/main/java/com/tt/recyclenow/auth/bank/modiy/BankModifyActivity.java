package com.tt.recyclenow.auth.bank.modiy;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;
import com.tt.recyclenow.bean.BankBean;

import butterknife.BindView;

/**
 * Created by tu on 2018/7/23.
 */

public class BankModifyActivity extends TBaseActivity<IBankModifyView, BankModifyPresenter>
        implements IBankModifyView {
    @BindView(R.id.et_card)
    EditText etCard;
    @BindView(R.id.tv_next)
    CheckedTextView tvNext;

    private BankBean.DataBean bankBean;

    @Override
    public void onLoadData(Object o) {
        bankBean = (BankBean.DataBean) o;

        try {
            etCard.setText(bankBean.getBankcard());
        }catch (Exception e){

        }
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
        return R.layout.bank_layout;
    }

    @Override
    public void initView() {
        etCard.addTextChangedListener(textWatcher);

        tvNext.setOnClickListener(view -> mPresenter.onSave(etCard.getText().toString().trim()));
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (checkRight()) {
                tvNext.setChecked(true);
            } else {
                tvNext.setChecked(false);
            }
        }
    };

    private boolean checkRight() {
        if (TextUtils.isEmpty(etCard.getText().toString().trim())) {
            return false;
        }
        return true;
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("修改银行卡");
    }

    @Override
    protected BankModifyPresenter createPresenter() {
        return new BankModifyPresenter();
    }

    @Override
    public void addOk(String msg) {
        ToastUtils.showShortToast(msg);
        finish();
    }
}
