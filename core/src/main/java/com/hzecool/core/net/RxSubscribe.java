package com.hzecool.core.net;


import android.text.TextUtils;

import com.hzecool.app.data.AppData;
import com.hzecool.app.data.ServerUrls;
import com.hzecool.app.data.UserData;
import com.hzecool.common.utils.ExceptionUtils;
import com.hzecool.common.utils.NetworkUtils;
import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.R;
import com.hzecool.core.log.L;

import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

import static com.hzecool.app.data.ServerUrls.urlOnLoginInfos;
import static com.hzecool.app.data.ServerUrls.urlUnLoginInfos;


/**
 * Rx自定义订阅者
 *
 * @author tutu
 * @date 2017/3/10
 */

public abstract class RxSubscribe<T> extends Subscriber<T> {
    protected abstract void onSuccess(T t);

    protected abstract void onFail(String msg);

    protected abstract void onNetError(String msg);

    @Override
    public void onNext(T t) {
        try {
            onSuccess(t);
        } catch (Exception e) {
            e.printStackTrace();
            L.logStackTraceToFile(e);
        }
    }


    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        L.logFile("请求失败:" + e.getMessage() + "\n" + ExceptionUtils.getExceptionString(e));
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showShortToast(ResourceUtils.getString(R.string.base_netError));
            onNetError(ResourceUtils.getString(R.string.base_netError));
        } else if (e instanceof SocketTimeoutException) {
            ToastUtils.showShortToast("连接超时");
            onFail(ResourceUtils.getString(R.string.connect_time_out));

            checkSdn();

        } else if (e instanceof BussinessException) {
            if (((BussinessException) e).getCode().equals("-11")) {

            } else {
                ToastUtils.showShortToast(e.getMessage());
                onFail(e.getMessage());
            }
        } else if (e instanceof HttpException) {
            // OnHttpException(e);
            checkSdn();

        } else {
            ToastUtils.showShortToast(ResourceUtils.getString(R.string.base_request_faile));
            onFail(ResourceUtils.getString(R.string.base_request_faile));
        }
    }

    /**
     * 切换sdn
     */
    private void checkSdn() {
        if (UserData.SLH_USER_INFO != null && !TextUtils.isEmpty(UserData.SLH_USER_INFO.getSn())) {
            if (AppData.productType() == AppData.PRODUCT_TYPE_SHOP_ASSISTANT) {
                //SdnManagerUtils.startSdnCheck(UserData.SLH_USER_INFO.getSn(), UserData.SLH_USER_INFO.getErpname(), UserData.USER_PHONE);
            } else {
                //SdnManagerUtils.startSdnCheck(UserData.SLH_USER_INFO.getSn(), UserData.SLH_USER_INFO.getErpname(), PhoneUtils.getDeviceMacAddress());
            }
        }
    }


    /**
     * 处理http异常
     */
    protected void OnHttpException(Throwable e) {

        if (((HttpException) e).code() == 404) {
            L.logFile("访问到服务器返回404 启动备用url列表循环");
            ServerUrls.currentPos++;
            if (UserData.SLH_USER_INFO == null || TextUtils.isEmpty(UserData.sessionid)) {
                if (urlUnLoginInfos.isEmpty()) {
                    L.e("备用日志列表 urlUnLoginInfos 为空");
                    onFail("请求失败,请稍后再试");
                    return;
                }
                if (ServerUrls.currentPos < urlUnLoginInfos.size()) {
                    ServerUrls.BaseUrl = urlUnLoginInfos.get(ServerUrls.currentPos)
                            .getIpUrl();
                    L.logFile("切换url成功 新url=" + ServerUrls.BaseUrl);
                } else {
                    ServerUrls.currentPos = 0;
                    ServerUrls.BaseUrl = urlUnLoginInfos.get(0).getIpUrl();
                    L.logFile("备用列表循环完毕从0开始 切换url成功 新url=" + ServerUrls.BaseUrl);
                }
            } else {
                if (urlOnLoginInfos.isEmpty()) {
                    L.e("备用日志列表 urlOnLoginInfos 为空");
                    onFail("请求失败,请稍后再试");
                    return;
                }
                if (ServerUrls.currentPos < urlOnLoginInfos.size()) {
                    ServerUrls.BaseUrl = urlOnLoginInfos.get(ServerUrls.currentPos)
                            .getIpUrl();
                    L.logFile("切换url成功 新url=" + ServerUrls.BaseUrl);
                } else {
                    ServerUrls.currentPos = 0;
                    ServerUrls.BaseUrl = urlOnLoginInfos.get(0).getIpUrl();
                    L.logFile("备用列表循环完毕从0开始 切换url成功 新url=" + ServerUrls.BaseUrl);
                }
            }
            //L.e("访问到服务器返回404 切换BaseUrl成功 ServerUrls.BaseUrl=" + ServerUrls.BaseUrl);
        }
        ToastUtils.showShortToast(ResourceUtils.getString(R.string.base_request_faile));
        onFail("请求失败,请稍后再试");

    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {
    }
}
