package com.tt.recyclenow.account.regist;

import com.hzecool.common.json.GsonUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.BaseRep;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author tutu
 * @time 2018/6/12
 */

public class RegisterPresenter extends TBasePresenter<IRegisterView> {
    @Override
    protected void start() {

    }

    public void getCode() {
        OkGo.post(ServerUrls.ROUTER + "app/sendMess_registered.htm")
                .params("userPho", getView().getPhone())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        BaseRep rep = GsonUtils.jsonToObj(s, BaseRep.class);
                        if (rep.getCode() == 0) {
                            ToastUtils.showShortToast("验证码已发送");
                            getView().getCodeOk();
                        } else {
                            ToastUtils.showShortToast(rep.getMsg());
                        }
                    }
                });
    }

    public void register() {
        OkGo.post(ServerUrls.ROUTER + "app/registeredUser.htm")
                .params("userPho", getView().getPhone())
                .params("pwd", getView().getPsw())
                .params("verificationCode", getView().getCode())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        BaseRep rep = GsonUtils.jsonToObj(s, BaseRep.class);
                        if (rep.getCode() == 0) {
                            ToastUtils.showShortToast(rep.getMsg());
                            getView().registOk();
                        } else {
                            ToastUtils.showShortToast(rep.getMsg());
                        }
                    }
                });
    }


}
