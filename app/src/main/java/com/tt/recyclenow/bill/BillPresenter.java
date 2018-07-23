package com.tt.recyclenow.bill;

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
 * @author tutu
 * @time 2018/6/8
 */

public class BillPresenter extends TBasePresenter<IBillView> {
    @Override
    protected void start() {
        getBank();
    }

    public void getBank(){
        OkGo.post(ServerUrls.ROUTER + "app/getUserBank.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        BankBean bean = JSON.parseObject(s, BankBean.class);
                        if (bean.getCode() == 0) {
                            getView().onLoadData(bean.getData());
                        } else {
                            getView().onLoadError(bean.getMsg());
                        }
                    }
                });
    }


    public void order(String id,String nc,String xh){
        OkGo.post(ServerUrls.ROUTER + "app/addJk.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .params("id",id)
                .params("nc",nc)
                .params("xh",xh)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        BaseRep bean = JSON.parseObject(s, BaseRep.class);
                        if (bean.getCode() == 0) {
                            getView().orderOk(bean.getMsg());
                        } else {
                            getView().onLoadError(bean.getMsg());
                        }
                    }
                });
    }
}
