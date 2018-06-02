package com.hzecool.core.manager;

import android.text.TextUtils;

import com.hzecool.app.bean.net.UrlBeanListBean;
import com.hzecool.app.data.AppData;
import com.hzecool.app.data.ParamConstant;
import com.hzecool.app.data.ServerUrls;
import com.hzecool.common.json.GsonUtils;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.common.utils.TimeUtils;
import com.hzecool.core.log.L;
import com.hzecool.core.log.LocalLogManager;
import com.hzecool.core.sp.SPOperation;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.yike.sdn_manager.bean.ConfigSDN;
import com.yike.sdn_manager.bean.ErrorBean;
import com.yike.sdn_manager.bean.ServerBean;
import com.yike.sdn_manager.bean.ServerResBean;
import com.yike.sdn_manager.callback.SdnCallback;
import com.yike.sdn_manager.callback.ServerListCallback;
import com.yike.sdn_manager.callback.SpeedCallback;
import com.yike.sdn_manager.main.SDNManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author guige
 * @date 2018/5/15
 * SDN 线路切换的管理的工具类
 */

public class SdnManagerUtils {

    private static long currentTime = 0;

    public static void startSdnCheck(String sn, String shopName, String mac) {
        //防止短时间内重复选择
        long time = System.currentTimeMillis();
        if (time - currentTime < 4 * 1000) {
            return;
        }
        currentTime = time;

        L.logFile("开始SDN测速---------开始SDN测速---------开始SDN测速---------开始SDN测速---------开始SDN测速");
        getOATestList(ServerUrls.OA_URL + "mycrm/callInterface.do?interfaceid=cs-getServerURLBySN&sn=" + sn,
                new ServerListCallback() {
                    @Override
                    public void loadServerList(ServerResBean serverResBean) {
                        SdnManagerUtils.init(SPOperation.enableSsl());
                        ConfigSDN configSDN = new ConfigSDN();
                        configSDN.isDebug = AppData.LOG_DEBUG;
                        if (serverResBean.getSc_sdn_timeout() > 0) {
                            configSDN.speedTimeOut = serverResBean.getSc_sdn_timeout();
                        }
                        SdnManagerUtils.setConfig(configSDN);
                        SdnManagerUtils.start(sn, shopName, mac, serverResBean);
                    }

                    @Override
                    public void onError(String message) {

                    }
                });

    }

    public static void init(boolean isHttps) {
        SDNManager.getInstance().init(com.hzecool.common.utils.Utils.getContext(), isHttps);
    }

    public static void setConfig(ConfigSDN configSDN) {
        SDNManager.getInstance().setConfig(configSDN);
    }

    public static void start(String sn, String shopName, String mac, ServerResBean bean) {
        L.logFile("SDN 请求参数: sn=" + sn + " shopName=" + shopName + " mac=" + mac);

        Map<String, String> map = new HashMap<>();
        map.put("baseUrl", ServerUrls.OA_URL + "mycrm/callInterface.do?interfaceid=cs-getServerURLBySN&sn=" + sn);
        map.put("mac", mac);
        map.put("sendMesUrl", "https://oapi.dingtalk.com/robot/send?access_token=08930de03f45d5fd707cfe9d25107c02860b7874d09f422ca30cf6eab2dfbf36");
        map.put("sn", sn);
        map.put("printhead", shopName);
        if (AppData.productType() == AppData.PRODUCT_TYPE_SHOP_ASSISTANT) {
            map.put("productName", "Android版店员助手");
        } else {
            map.put("productName", "Android版仓配助手");
        }

        SDNManager.getInstance().startCheck(map, new SdnCallback() {
            @Override
            public void onSuccess(ServerBean serverBean) {
                if (null != serverBean) {
                    ServerUrls.BaseUrl = "http://" + serverBean.getSlhurl() + "/slh/";

                    String urlList = SPUtils.getString(ParamConstant.URL_LIST_LOGIN);
                    if (!TextUtils.isEmpty(urlList)) {
                        ServerUrls.urlOnLoginInfos = GsonUtils.jsonToArrayList(urlList, UrlBeanListBean.UrlBean.class);
                    } else {
                        ServerUrls.urlOnLoginInfos = new ArrayList<>();
                    }
                    UrlBeanListBean.UrlBean urlBean = new UrlBeanListBean.UrlBean();
                    urlBean.setIpUrl(ServerUrls.BaseUrl);
                    urlBean.setName(serverBean.getName());
                    ServerUrls.urlOnLoginInfos.add(0, urlBean);
                    //保存在sp
                    SPUtils.putString(ParamConstant.URL_LIST_LOGIN, GsonUtils.listToJson(ServerUrls.urlOnLoginInfos));
                    serverBean.setShowResult(true);
                    L.logFile("SDN测速 找到最优路线=" + serverBean.toString());
                    L.logFile("切换路由成功" + ServerUrls.BaseUrl + " " + TimeUtils.millis2String(System.currentTimeMillis()));
                    L.logFile("缓存最优线路作为baseUrl=" + ServerUrls.BaseUrl);
                }
            }

            @Override
            public void onFailed(ErrorBean bean) {
                //测速功能被关闭
                L.logFile("SDN切换异常原因：" + bean.getMessage());
                /**
                 * 上传日志
                 */
                LocalLogManager.getInstanse().uploadLogByName(TimeUtils.getNowTimeString1(), null);
            }
        }, bean, new SpeedCallback() {
            @Override
            public void testSuccess(ServerBean bean) {

            }

            @Override
            public void log(String msg) {
                L.logFile(msg);
            }

            @Override
            public void onError(String message) {

            }
        });
    }


    public static void getOATestList(String url, ServerListCallback callback) {
        OkGo.get(url).execute(new StringCallback() {
            @Override
            public void onSuccess(String str, Call call, Response response) {
                if (response.code() == 200) {
                    ServerResBean resBean = GsonUtils.jsonToObj(str, ServerResBean.class);

                    if (resBean == null) {
                        L.logFile("SDN 请求OA测试列表失败");
                        dealOaListRequestFail(callback);
                        return;
                    }

                    if (resBean.getServerList() != null) {
                        for (ServerBean serverBean : resBean.getServerList()) {
                            serverBean.setShowResult(false);
                        }
                    }

                    L.logFile("SDN 获取OA返回的测速列表成功:");
                    L.logFile(resBean.toString());

                    /**
                     * 如果列表不为空  就缓存
                     */
                    if (resBean.getServerList() != null) {
                        SPOperation.saveOATestList(str);
                        callback.loadServerList(resBean);
                    } else {
                        L.logFile("SDN 请求OA测试列表失败");
                        dealOaListRequestFail(callback);
                    }
                } else {
                    L.logFile("SDN 请求OA测试列表失败");
                    dealOaListRequestFail(callback);
                }
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                L.logFile("SDN 请求OA测试列表失败");
                dealOaListRequestFail(callback);
            }
        });
    }

    /**
     * OA请求失败 则使用缓存的OA列表  测速 如果缓存存在的话
     */
    public static void dealOaListRequestFail(ServerListCallback callback) {
        String str = SPOperation.getOATestList();

        if (TextUtils.isEmpty(str)) {
            L.logFile("SDN 没有缓存的Oa测速列表,不进行测速");
            callback.onError("SDN 没有缓存的OA测速列表");
        } else {
            ServerResBean resBean = GsonUtils.jsonToObj(str, ServerResBean.class);
            L.logFile("SDN 成功获取缓存的OA测速列表 列表数据如下:" + str);
            callback.loadServerList(resBean);
        }
    }
}
