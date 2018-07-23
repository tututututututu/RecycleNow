package com.tt.recyclenow.mine;

import com.alibaba.fastjson.JSON;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.ContatcUsBean;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author tutu
 * @time 2018/6/9
 */

public class MinePresenter extends TBasePresenter<IMineView> {
    @Override
    protected void start() {
        authStatus();
    }

    public void authStatus() {
        OkGo.post(ServerUrls.ROUTER + "app/contactCustomerService.htm")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        ContatcUsBean bean = JSON.parseObject(s,ContatcUsBean.class);

                        getView().onLoadData(bean);
                    }
                });
    }

}
