package com.tt.recyclenow.account.login;

import com.hzecool.common.json.GsonUtils;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.Constants;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.LoginBean;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by tu on 2018/6/9.
 */

public class LoginPresenter extends TBasePresenter<ILoginView>{
    @Override
    protected void start() {

    }

    public void login(){
        OkGo.post(ServerUrls.ROUTER + "app/loginUser.htm")
                .params("userPho", getView().getPhone())
                .params("pwd", getView().getPsw())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        LoginBean rep = GsonUtils.jsonToObj(s, LoginBean.class);
                        if (rep.getCode() == 0) {
                            getView().loginOk(rep);
                            SPUtils.putString(Constants.SP_TOKENDS,rep.getData().getTokens());
                            SPUtils.putString(Constants.SP_USER_NAME,rep.getData().getUserPho());
                        } else {
                            ToastUtils.showShortToast(rep.getMsg());
                        }
                    }
                });
    }
}
