package com.hzecool.core.activity.imagepager;

import com.hzecool.core.activity.imagepager.dataprovider.DataProvider;
import com.hzecool.core.base.TBasePresenter;
import com.hzecool.core.bean.NetQRbean;
import com.hzecool.core.net.RxHelper;
import com.hzecool.core.net.RxSubscribe;

/**
 * Created by song on 2017/8/30.
 */

public class ImagePagerPresenter extends TBasePresenter<IImagePagerView> {
    @Override
    protected void start() {

    }

    /**
     * 获取小程序二维码
     * @param styleId
     */
    public void QuerryQRCode(String styleId){
        mSubscriptionList.add(DataProvider.querryQRCode(styleId)
                .compose(RxHelper.RxSlhHandleResult())
                .subscribe(new RxSubscribe<NetQRbean>() {
                    @Override
                    protected void onSuccess(NetQRbean netQRbean) {
                        getView().onLoadData(netQRbean);
                    }

                    @Override
                    protected void onFail(String msg) {
                         getView().onLoadError(msg);
                    }

                    @Override
                    protected void onNetError(String msg) {
                        getView().onNetError(msg);
                    }
                }));
    }
}
