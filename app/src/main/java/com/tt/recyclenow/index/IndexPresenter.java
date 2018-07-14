package com.tt.recyclenow.index;

import com.alibaba.fastjson.JSON;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.IndexBanner;
import com.tt.recyclenow.bean.PhonePriceBean;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author tutu
 * @time 2018/6/3
 */

public class IndexPresenter extends TBasePresenter<IIndexView> {
    @Override
    protected void start() {
        getBanner();
    }

    public void getBanner() {
        OkGo.post(ServerUrls.ROUTER + "app/adverList.htm")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        IndexBanner indexBanner = JSON.parseObject(s, IndexBanner.class);
                        if (indexBanner.getCode() == 0) {
                            getView().BannerOk(indexBanner);
                        } else {
                            ToastUtils.showShortToast(indexBanner.getMsg());
                        }
                    }
                });
    }

    public void getPhonePrice(String module, String memory) {
        OkGo.post(ServerUrls.ROUTER + "app/getPhonePrice.htm")
                .params("xh", module)
                .params("nc", memory)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        PhonePriceBean rep =  JSON.parseObject(s, PhonePriceBean.class);
                        //PhonePriceBean rep = GsonUtils.jsonToObj(s, PhonePriceBean.class);
                        if (rep.getCode() == 0) {
                            getView().PhonePriceOk(rep);
                        } else {
                            getView().PhonePriceFail(rep);
                        }
                    }
                });
    }
}
