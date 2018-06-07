package com.tt.recyclenow.check.checking;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.common.utils.DeviceUtils;
import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;
import com.tt.recyclenow.check.finish.CheckingResultActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

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
    @BindView(R.id.tv_checking)
    TextView tvChecking;

    private Timer timer;
    private int progress = 0;

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


        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (progress >= 100) {
                    progress = 100;
                    timer.cancel();
                    circleView.post(() -> {
                        tvChecking.setText("检测完成");
                        Intent intent = new Intent(CheckPhoneActivity.this, CheckingResultActivity.class);
                        intent.putExtra("info", cs + xh + store);
                        startActivity(intent);
                        finish();
                    });
                } else {
                    progress += randomNum();
                    circleView.post(() -> {
                        circleView.setValue(progress);
                        tvChecking.setText("正在检测中...");
                    });
                }
            }
        }, 0, 50);

        tvInfo.setText(cs + xh + "\n" + store);
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    private int randomNum() {
        Random random = new Random();
        return random.nextInt(3);
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("手机检测");
    }

    @Override
    protected CheckPhonePresenter createPresenter() {
        return new CheckPhonePresenter();
    }
}
