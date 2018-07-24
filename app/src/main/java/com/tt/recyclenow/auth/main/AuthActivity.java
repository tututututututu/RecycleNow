package com.tt.recyclenow.auth.main;

import android.content.Intent;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hzecool.app.bean.app.ARouterUrl;
import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;
import com.tt.recyclenow.auth.idcard.IDCardActivity;
import com.tt.recyclenow.auth.person.PersonInfoAuthActivity;
import com.tt.recyclenow.bean.AuthStatusBean;
import com.tt.recyclenow.recyclerList.RecyclerListActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author tutu
 * @time 2018/6/7
 */

public class AuthActivity extends TBaseActivity<IAuthView, AuthPresenter>
        implements IAuthView {
    @BindView(R.id.tv_sm)
    CheckedTextView tvSm;
    @BindView(R.id.rl1)
    RelativeLayout rl1;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.tv_gr)
    CheckedTextView tvGr;
    @BindView(R.id.rl2)
    RelativeLayout rl2;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.tv_sj)
    CheckedTextView tvSj;
    @BindView(R.id.rl3)
    RelativeLayout rl3;
    @BindView(R.id.iv4)
    ImageView iv4;
    @BindView(R.id.tv_tb)
    CheckedTextView tvTb;
    @BindView(R.id.rl4)
    RelativeLayout rl4;
    @BindView(R.id.iv5)
    ImageView iv5;
    @BindView(R.id.tv_xx)
    CheckedTextView tvXx;
    @BindView(R.id.rl5)
    RelativeLayout rl5;
    @BindView(R.id.ctv_next)
    CheckedTextView ctvNext;

    /**
     * 活体检测人用户的名字,身份证号码
     */
    private String mName;
    private String mNum;

    private AuthStatusBean authStatusBean;

    private String nextTitle;

    @Override
    public int getLayoutID() {
        return R.layout.auth_activity_layout;
    }

    @Override
    public void initView() {
        authStatusBean = getIntent().getParcelableExtra("auth");
        if (authStatusBean == null) {
            return;
        }

        updateView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.authStatus();
    }

    private void updateView() {
        if ("1".equals(authStatusBean.getData().getPhonexs())) {
            rl3.setVisibility(View.VISIBLE);
        } else {
            rl3.setVisibility(View.GONE);
        }
        if ("1".equals(authStatusBean.getData().getTbxs())) {
            rl4.setVisibility(View.VISIBLE);
        } else {
            rl4.setVisibility(View.GONE);
        }
        if ("1".equals(authStatusBean.getData().getXxxs())) {
            rl5.setVisibility(View.VISIBLE);
        } else {
            rl5.setVisibility(View.GONE);
        }

        if ("1".equals(authStatusBean.getData().getNameMark())) {
            tvSm.setChecked(true);
            tvSm.setText("已认证");
        } else {
            tvSm.setChecked(false);
            tvSm.setText("未认证");
        }

        if ("1".equals(authStatusBean.getData().getGrMark())) {
            tvGr.setChecked(true);
            tvGr.setText("已认证");
        } else {
            tvGr.setChecked(false);
            tvGr.setText("未认证");
        }

        if ("2".equals(authStatusBean.getData().getPhoneMark())) {
            tvSj.setChecked(true);
            tvSj.setText("已认证");
        } else if ("1".equals(authStatusBean.getData().getPhoneMark())) {
            tvSj.setChecked(false);
            tvSj.setText("认证中");
        } else {
            tvSj.setChecked(false);
            tvSj.setText("未认证");
        }

        if ("2".equals(authStatusBean.getData().getTbMark())) {
            tvTb.setChecked(true);
            tvTb.setText("已认证");
        } else if ("1".equals(authStatusBean.getData().getTbMark())) {
            tvTb.setChecked(false);
            tvTb.setText("认证中");
        } else {
            tvTb.setChecked(false);
            tvTb.setText("未认证");
        }

        if ("2".equals(authStatusBean.getData().getXxMark())) {
            tvXx.setChecked(true);
            tvXx.setText("已认证");
        } else if ("1".equals(authStatusBean.getData().getXxMark())) {
            tvXx.setChecked(true);
            tvXx.setText("认证中");
        } else {
            tvXx.setChecked(false);
            tvXx.setText("未认证");
        }
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("认证中心");
    }

    @Override
    protected AuthPresenter createPresenter() {
        return new AuthPresenter();
    }

    @Override
    public void onLoadData(Object o) {

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

    @OnClick({R.id.rl1, R.id.rl2, R.id.rl3, R.id.rl4, R.id.rl5, R.id.ctv_next})
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.rl1:
                idCardAuth();
                break;
            case R.id.rl2:
                intent = new Intent(this, PersonInfoAuthActivity.class);
                startActivity(intent);
                break;
            case R.id.rl3:
                mPresenter.getUrl(authStatusBean.getData().getPhoneUrl());
                nextTitle = "手机认证";
                break;
            case R.id.rl4:
                mPresenter.getUrl(authStatusBean.getData().getTbUrl());
                nextTitle = "淘宝认证";
                break;
            case R.id.rl5:
                mPresenter.getUrl(authStatusBean.getData().getXxUrl());
                nextTitle = "学信认证";
                break;
            case R.id.ctv_next:
                mPresenter.finishAuthStatus();
                break;
            default:
                break;
        }
    }

    /**
     * 实名认证 (身份证识别)
     */
    private void idCardAuth() {

        Intent intent = new Intent(this, IDCardActivity.class);
        startActivity(intent);
    }


    @Override
    public void onAuthStatusOk(AuthStatusBean bean) {
        this.authStatusBean = bean;
    }

    @Override
    public void onGetAuthUrlOk(String url) {
        ARouter.getInstance().build(ARouterUrl.AR_URL_WEB_VIEW)
                .withString("url", url)
                .withString("title", this.nextTitle)
                .navigation(this);
    }

    @Override
    public void canNext() {
        Intent intent1 = new Intent(this, RecyclerListActivity.class);
        startActivity(intent1);
    }
}
