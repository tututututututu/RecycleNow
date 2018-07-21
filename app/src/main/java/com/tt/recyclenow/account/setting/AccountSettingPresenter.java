package com.tt.recyclenow.account.setting;

import com.alibaba.fastjson.JSON;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.Constants;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.BaseRep;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author tutu
 * @time 2018/6/9
 */

public class AccountSettingPresenter extends TBasePresenter<IAccountSettingView> {
    @Override
    protected void start() {

    }

    public void logout(){
        OkGo.post(ServerUrls.ROUTER + "app/logout.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
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

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        getView().onLoadError(e.getMessage());
                    }
                });
    }
}
