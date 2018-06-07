package com.tt.recyclenow.check.finish;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hzecool.core.activity.webview.JsBridgeWebViewActivity;
import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;
import com.tt.recyclenow.check.checking.CheckPhoneActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author tutu
 * @time 2018/6/6
 */

public class CheckingResultActivity extends TBaseActivity<ICheckingResultView, CheckingResultPresenter>
        implements ICheckingResultView {
    @BindView(R.id.tv_info)
    TextView tvInfo;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_recheck)
    TextView tvRecheck;
    @BindView(R.id.tv_sale)
    TextView tvSale;
    @BindView(R.id.tv_sale_use)
    TextView tvSaleUse;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.cb)
    CheckBox cb;
    @BindView(R.id.tv_promise)
    TextView tvPromise;

    private int memory = 0;
    private String info = "";

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
        return R.layout.check_result_activity_layout;
    }

    @Override
    public void initView() {
        tvPrice.setText("¥ " + getPrice());
        tvInfo.setText(info + " 回收价格");
    }


    private int getPrice() {
        if (memory > 0 && 4 <= memory) {
            return 300;
        } else if (memory > 4 && 8 <= memory) {
            return 500;
        } else if (memory > 8 && 16 <= memory) {
            return 800;
        } else if (memory > 16 && 32 <= memory) {
            return 1150;
        } else if (memory > 32 && 64 <= memory) {
            return 1320;
        } else if (memory > 64 && 128 <= memory) {
            return 1580;
        } else {
            return 1880;
        }
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("估算价格");
    }

    @Override
    protected CheckingResultPresenter createPresenter() {
        return new CheckingResultPresenter();
    }


    @OnClick({R.id.tv_recheck, R.id.tv_sale, R.id.tv_sale_use, R.id.tv_promise})
    protected void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.tv_recheck:
                intent = new Intent(this, CheckPhoneActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_sale:
                intent = new Intent(this, CheckPhoneActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_sale_use:
                intent = new Intent(this, CheckPhoneActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_promise:
                intent = new Intent(this, JsBridgeWebViewActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
