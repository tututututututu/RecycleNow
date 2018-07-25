package com.tt.recyclenow.auth.bank.modiy;

import com.alibaba.fastjson.JSON;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.Constants;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.BankBean;
import com.tt.recyclenow.bean.BaseRep;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by tu on 2018/7/23.
 */

public class BankModifyPresenter extends TBasePresenter<IBankModifyView> {
    @Override
    protected void start() {
        getBank();
    }

    public void onSave(String bankcard) {
        OkGo.post(ServerUrls.ROUTER + "app/addBankCard.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .params("bankcard", bankcard)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        BaseRep bean = JSON.parseObject(s, BaseRep.class);
                        if (bean.getCode() == 0) {
                            getView().addOk(bean.getMsg());
                        } else {
                            getView().onLoadError(bean.getMsg());
                        }

                    }
                });
    }

    public void getBank() {
        OkGo.post(ServerUrls.ROUTER + "app/getUserBank.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        BankBean bean = JSON.parseObject(s, BankBean.class);
                        if (bean.getCode() == 0) {
                            //getView().noBank(bean.getMsg());
                            getView().onLoadData(bean.getData());
                        } else {
                            getView().noBank(bean.getMsg());
                        }
                    }
                });
    }
}
