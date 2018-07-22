package com.tt.recyclenow.recyclerList;

import com.alibaba.fastjson.JSON;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.Constants;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.RecycleBean;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author tutu
 * @time 2018/6/8
 */

public class RecyclerListPresenter extends TBasePresenter<IRecyclerListView> {
    @Override
    protected void start() {
        getList();
    }

    public void getList(){
        OkGo.post(ServerUrls.ROUTER + "app/getCpList.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        RecycleBean bean = JSON.parseObject(s, RecycleBean.class);
                        if (bean.getCode() == 0) {
                            getView().onLoadData(bean.getData());
                        } else {
                            getView().onLoadError(bean.getMsg());
                        }
                    }
                });
    }
}
