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

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import at.grabner.circleprogress.CircleProgressView;
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
    @BindView(R.id.circleView)
    CircleProgressView circleProgressView;
    @BindView(R.id.tv_checking)
    TextView tvChecking;

    private Timer timer;
    private int progress = 0;

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

        startProgress();
    }

    private void startProgress() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (progress >= 100) {
                    progress = 100;
                    timer.cancel();
                    circleProgressView.post(() -> {
                        tvChecking.setText("检测完成");
                    });
                } else {
                    progress += randomNum();
                    circleProgressView.post(() -> {
                        circleProgressView.setValue(progress);
                        tvChecking.setText("正在检测中...");
                    });
                }
            }
        }, 0, 50);
    }

    private int randomNum() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private int getPrice() {
        return getIntent().getIntExtra("price",0);
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
