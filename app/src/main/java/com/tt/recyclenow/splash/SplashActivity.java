package com.tt.recyclenow.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.hzecool.core.log.L;
import com.hzecool.widget.materialdialog.MaterialDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.R;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.RouterBean;
import com.tt.recyclenow.main.MainActivity;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author tt
 */
public class SplashActivity extends AppCompatActivity {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        v = findViewById(R.id.rl_root);


        OkGo.post("https://www.qumiaodai.cn/app/getPathUrl.htm")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        L.e(s);

                        RouterBean bean = JSON.parseObject(s, RouterBean.class);
                        if (bean.getCode() == 0) {
                            ServerUrls.ROUTER = bean.getData().getUrl();
                            v.postDelayed(
                                    () -> {
                                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                                        finish();
                                    }
                                    , 1000);
                        } else {
                            new MaterialDialog.Builder(SplashActivity.this)
                                    .title("提示")
                                    .content(bean.getMsg())
                                    .cancelable(false)
                                    .positiveText("确定")
                                    .onPositive((dialog, which) -> {
                                        dialog.cancel();
                                    })
                                    .build();
                        }
                    }
                });
    }
}
