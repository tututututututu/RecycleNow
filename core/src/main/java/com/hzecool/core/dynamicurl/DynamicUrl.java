package com.hzecool.core.dynamicurl;

import android.text.TextUtils;

import com.hzecool.app.bean.net.UrlBeanListBean;
import com.hzecool.app.data.ParamConstant;
import com.hzecool.app.data.ServerUrls;
import com.hzecool.app.data.UserData;
import com.hzecool.common.json.GsonUtils;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.bean.BaseResponseBean;
import com.hzecool.core.bean.JsonParamBean;
import com.hzecool.core.log.L;
import com.hzecool.core.net.Api;
import com.hzecool.core.net.RxHelper;
import com.hzecool.core.net.RxSubscribe;

import java.util.HashMap;
import java.util.List;

import rx.observables.ConnectableObservable;


/**
 * 获取动态url数据集合  分为已经在注册中心注册过和没有注册过两种情况
 * 根据情况来请求更新集合
 * <p>
 * 在此遇到最大的问题就是Rxjava中的一个Observable 多次订阅的问题
 * 我们把@getUnLoginUrls() 这个方法获取的Observable订阅了一次并返回出去之后
 * 在其他地方订阅了一次，导致的问题就是执行多次请求。
 * 解决办法就是如下面的方法将Observable.publish()方法将Observable转化为ConnectableObservable类型
 * 在所有的订阅者订阅完之后调用ConnectableObservable实例的.connect()方法激活被观察者发送数据。并保证所有的
 * 订阅者收取到同样的数据
 * <p>
 * Created by tutu on 2017/3/1.
 */

public class DynamicUrl {

    /**
     * 未在注册中心登录获取服务器地址
     *
     * @param bDomainCode 业务码
     * @param protocol    协议 https
     * @return
     */
    public static ConnectableObservable<BaseResponseBean<UrlBeanListBean>> getUnLoginUrls(String bDomainCode, String protocol, String
            mobile, String captcha, String userName, String password, String nickName) {

        JsonParamBean jsonParamBean = new JsonParamBean();
        if (TextUtils.isEmpty(bDomainCode)) {
            jsonParamBean.setBdomainCode(bDomainCode);
        } else {
            jsonParamBean.setBdomainCode(bDomainCode);
        }
        if (TextUtils.isEmpty(protocol)) {
            jsonParamBean.setProtocol(protocol);
        } else {
            jsonParamBean.setProtocol(protocol);
        }
        jsonParamBean.setMobile(mobile);
        jsonParamBean.setCaptcha(captcha);
        jsonParamBean.setUserName(userName);
        jsonParamBean.setPassword(password);
        jsonParamBean.setNickName(nickName);

        HashMap<String, String> params = new HashMap<>();
        params.put(ParamConstant.APIKEY, "ec-mdm-user-reg");
        params.put(ParamConstant.JSON_PARAMS, GsonUtils.object2Json(jsonParamBean));

        ConnectableObservable<BaseResponseBean<UrlBeanListBean>> observable = Api.getInstanceWithBaseUrl(RouterApiService.class,
                ServerUrls.ucUrl).requestUrlList(params).publish();

        observable.compose(RxHelper.RxHandleResult())
                .subscribe(new RxSubscribe<UrlBeanListBean>() {
                    @Override
                    protected void onSuccess(UrlBeanListBean urlBeanList) {
                        if (urlBeanList.getRows() != null && urlBeanList.getRows().size() > 0) {
                            L.i("前一条BaseUrl=" + ServerUrls.BaseUrl);
                            ServerUrls.urlUnLoginInfos = urlBeanList.getRows();
                            ServerUrls.BaseUrl = urlBeanList.getRows().get(0).getIpUrl();
                            //保存请求到的url列表到sp
                            SPUtils.putString(ParamConstant.URL_LIST_UNLOGIN, GsonUtils.listToJson(ServerUrls.urlUnLoginInfos));
                            L.logFile("保存未注册url列表成功=" + GsonUtils.listToJson(ServerUrls.urlUnLoginInfos));
                            L.i("更新未注册情况url=" + ServerUrls.urlUnLoginInfos.toString());
                            L.i("当前BaseUrl=" + ServerUrls.BaseUrl);
                        }
                    }

                    @Override
                    protected void onFail(String msg) {

                    }

                    @Override
                    protected void onNetError(String msg) {

                    }
                });

        return observable;
    }


    /**
     * 已在注册中心注册过获取服务器地址
     *
     * @return
     */
    public static ConnectableObservable<BaseResponseBean<UrlBeanListBean>> getOnLoginUrls(String loginName) {

        JsonParamBean jsonParamBean = new JsonParamBean();

        jsonParamBean.setBdomainCode(ServerUrls.bDomainCode);

        jsonParamBean.setProtocol(ServerUrls.protocol);

        jsonParamBean.setLoginName(loginName);

        HashMap<String, String> params = new HashMap<>();
        params.put(ParamConstant.APIKEY, "ec-mdm-ugr-getugrbyprovicecode");
        params.put(ParamConstant.JSON_PARAMS, GsonUtils.object2Json(jsonParamBean));


        ConnectableObservable<BaseResponseBean<UrlBeanListBean>> observable = Api.getInstanceWithBaseUrl(RouterApiService.class,
                ServerUrls.ucUrl).requestUrlList(params).publish();

        observable.compose(RxHelper.RxHandleResult())
                .subscribe(new RxSubscribe<UrlBeanListBean>() {
                    @Override
                    protected void onSuccess(UrlBeanListBean urlBeanList) {
                        if (urlBeanList.getRows() != null && urlBeanList.getRows().size() > 0) {

                            L.i("前一条BaseUrl=" + ServerUrls.BaseUrl);
                            ServerUrls.urlOnLoginInfos = urlBeanList.getRows();
                            ServerUrls.BaseUrl = urlBeanList.getRows().get(0).getIpUrl();

                            //保存请求到的url列表到sp
                            SPUtils.putString(ParamConstant.URL_LIST_LOGIN, GsonUtils.listToJson(ServerUrls.urlOnLoginInfos));
                            L.logFile("保存已注册url列表成功=" + GsonUtils.listToJson(ServerUrls.urlOnLoginInfos));

                            L.i("更新已注册情况url=" + ServerUrls.urlOnLoginInfos.toString());
                            L.i("当前BaseUrl=" + ServerUrls.BaseUrl);
                        }
                    }

                    @Override
                    protected void onFail(String msg) {

                    }

                    @Override
                    protected void onNetError(String msg) {

                    }
                });

        return observable;
    }


    /**
     * 检查当前url是否可用
     *
     * @return
     */
    public static boolean cheakUrlValid() {

        if (UserData.USER_INFO != null && !TextUtils.isEmpty(UserData.USER_INFO.getSessionId())) {
            if (ServerUrls.urlOnLoginInfos != null && !ServerUrls.urlOnLoginInfos.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } else {
            if (ServerUrls.urlUnLoginInfos != null && !ServerUrls.urlUnLoginInfos.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 初始化全局数据中的url变量 从sp中读取
     */
    public static void initBaseUrl() {

        if (!TextUtils.isEmpty(UserData.sessionid)) {
            List<UrlBeanListBean.UrlBean> urlBeanLists = GsonUtils.jsonToArrayList(SPUtils.getString(ParamConstant.URL_LIST_LOGIN),
                    UrlBeanListBean.UrlBean.class);

            if (urlBeanLists != null && urlBeanLists.size() > 0) {
                ServerUrls.BaseUrl = urlBeanLists.get(0).getIpUrl();
                ServerUrls.urlOnLoginInfos = urlBeanLists;
                L.logFile("读取SP已注册的url列表成功=" + urlBeanLists.toString());
                L.logFile("当前BaseUrl=" + ServerUrls.BaseUrl);
            }

        } else {

            List<UrlBeanListBean.UrlBean> urlBeanLists = GsonUtils.jsonToArrayList(SPUtils.getString(ParamConstant.URL_LIST_UNLOGIN),
                    UrlBeanListBean.UrlBean.class);

            if (urlBeanLists != null && urlBeanLists.size() > 0) {
                ServerUrls.BaseUrl = urlBeanLists.get(0).getIpUrl();
                ServerUrls.urlUnLoginInfos = urlBeanLists;
                L.logFile("读取SP未注册的url列表成功=" + urlBeanLists.toString());
                L.logFile("当前BaseUrl=" + ServerUrls.BaseUrl);
            }

        }


    }
}
