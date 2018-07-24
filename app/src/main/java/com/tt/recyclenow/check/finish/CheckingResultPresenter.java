package com.tt.recyclenow.check.finish;

import com.alibaba.fastjson.JSON;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.Constants;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.AuthStatusBean;
import com.tt.recyclenow.bean.ZigeBean;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author tutu
 * @time 2018/6/6
 */

public class CheckingResultPresenter extends TBasePresenter<ICheckingResultView> {
    @Override
    protected void start() {
        authStatus();
        zige();
    }

    public void authStatus() {
        OkGo.post(ServerUrls.ROUTER + "app/getUserMark.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        AuthStatusBean bean = JSON.parseObject(s, AuthStatusBean.class);
                        getView().onAuthStatusOk(bean);
                    }
                });
    }

    public void zige() {
        OkGo.post(ServerUrls.ROUTER + "app/getCloseMark.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        ZigeBean zigeBean = JSON.parseObject(s,ZigeBean.class);

                        getView().onZige(zigeBean);
                    }
                });
    }
}
