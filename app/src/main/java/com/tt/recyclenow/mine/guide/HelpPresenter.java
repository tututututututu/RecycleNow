package com.tt.recyclenow.mine.guide;

import com.alibaba.fastjson.JSON;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.HelpBean;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by tu on 2018/7/24.
 */

public class HelpPresenter extends TBasePresenter<IHelpView> {
    @Override
    protected void start() {
        authStatus();
    }

    public void authStatus() {
        OkGo.post(ServerUrls.ROUTER + "app/question.htm")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        HelpBean helpBean = JSON.parseObject(s,HelpBean.class);

                        if (helpBean.getCode()==0){
                            getView().onLoadData(helpBean.getData());
                        }else {
                            getView().onLoadError(helpBean.getMsg());
                        }
                    }
                });
    }
}
