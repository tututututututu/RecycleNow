package com.tt.recyclenow.recycleHistory;

import com.alibaba.fastjson.JSON;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.Constants;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.RecycleHistoryBean;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author tutu
 * @time 2018/6/8
 */

public class HistorytPresenter extends TBasePresenter<IHistoryListView> {
    @Override
    protected void start() {
        getList();
    }

    public void getList(){
        OkGo.post(ServerUrls.ROUTER + "app/recyclingRecords.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        RecycleHistoryBean bean = JSON.parseObject(s, RecycleHistoryBean.class);
                        if (bean.getCode() == 0) {
                            getView().onLoadData(bean.getData());
                        } else {
                            getView().onLoadError(bean.getMsg());
                        }
                    }
                });
    }
}
