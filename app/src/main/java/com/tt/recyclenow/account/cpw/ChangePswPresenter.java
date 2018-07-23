package com.tt.recyclenow.account.cpw;

import com.alibaba.fastjson.JSON;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.Constants;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.BaseRep;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by tu on 2018/6/9.
 */

public class ChangePswPresenter extends TBasePresenter<IChangePswView> {
    @Override
    protected void start() {

    }

    public void change(String pwd,String yzm){
        OkGo.post(ServerUrls.ROUTER + "app/updateUserPwd.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .params("pwd", pwd)
                .params("yzm", yzm)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        BaseRep rep = JSON.parseObject(s, BaseRep.class);
                        if (rep.getCode() == 0) {
                            getView().onLoadData(rep);
                        } else {
                            getView().onLoadError(rep.getMsg());
                        }
                    }
                });
    }

    public void getCode(String phone) {
        OkGo.post(ServerUrls.ROUTER + "app/sendMess_updatePwd.htm")
                .params("userPho", phone)
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        BaseRep rep = JSON.parseObject(s, BaseRep.class);
                        if (rep.getCode() == 0) {
                            ToastUtils.showShortToast("验证码已发送");
                        } else {
                            ToastUtils.showShortToast(rep.getMsg());
                        }
                    }
                });
    }
}
