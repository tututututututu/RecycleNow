package com.tt.recyclenow.auth.main;

import com.alibaba.fastjson.JSON;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.Constants;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.AuthStatusBean;
import com.tt.recyclenow.bean.BaseRep;
import com.tt.recyclenow.bean.WebAuthBean;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author tutu
 * @time 2018/6/7
 */

public class AuthPresenter extends TBasePresenter<IAuthView> {
    @Override
    protected void start() {

    }

    public void getUrl(String url) {
        OkGo.post(ServerUrls.ROUTER + url)
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        WebAuthBean bean = JSON.parseObject(s, WebAuthBean.class);
                        if (bean.getCode() == 0) {
                            getView().onGetAuthUrlOk(bean.getData().getUrl());
                        } else {
                            getView().onLoadError(bean.getMsg());
                        }

                    }
                });
    }

    public void authStatus() {
        OkGo.post(ServerUrls.ROUTER + "app/getUserMark.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        AuthStatusBean bean = JSON.parseObject(s, AuthStatusBean.class);

                        if (bean.getCode() == 0) {
                            getView().onAuthStatusOk(bean);
                        } else {
                            getView().onLoadError(bean.getMsg());
                        }

                    }
                });
    }

    public void finishAuthStatus() {
        OkGo.post(ServerUrls.ROUTER + "app/getUserMark_qr.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        BaseRep rep = JSON.parseObject(s,BaseRep.class);
                        if (rep.getCode()==0){
                            getView().canNext();
                        }else {
                            getView().onLoadError(rep.getMsg());
                        }
                    }
                });
    }
}
