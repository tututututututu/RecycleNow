package com.yike.sdn_manager.modle;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.yike.sdn_manager.bean.SendMesBean;
import com.yike.sdn_manager.bean.ServerBean;
import com.yike.sdn_manager.bean.ServerResBean;
import com.yike.sdn_manager.bean.SpeedBean;
import com.yike.sdn_manager.callback.SendMsgCallback;
import com.yike.sdn_manager.callback.ServerListCallback;
import com.yike.sdn_manager.callback.SpeedCallback;
import com.yike.sdn_manager.utils.LogUtils;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author guige
 * @date 2018/5/9
 * <p>
 * 获取服务器列表的请求
 */

public class ServerModel {


    /***
     * 获取服务列表
     * @param baseUrl 地址
     * @param callback 回调
     */
    public static void getServerList(String baseUrl, final ServerListCallback callback) {

        OkGo.get(baseUrl).execute(new StringCallback() {
            @Override
            public void onSuccess(String str, Call call, Response response) {
                if (response.code() == 200) {
                    LogUtils.i("sdnManager", "response=" + str + " response=" + response.code());
                    ServerResBean resBean = new Gson().fromJson(str, ServerResBean.class);
                    if (null != resBean) {
                        callback.loadServerList(resBean);
                    } else {
                        callback.onError("请求服务器列表失败");
                    }

                } else {
                    callback.onError("请求服务器列表失败");
                }
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                callback.onError("服务器响应错误");
            }
        });

    }


    /**
     * 开始测速
     *
     * @param baseUrl  地址
     * @param mac      mac
     * @param callback 回调
     */
    public static void testSpeed(final String baseUrl, String mac, final ServerBean serverBean, long timeOut,
                                 final SpeedCallback callback) {
        serverBean.setClientTime(System.currentTimeMillis());

        String url = baseUrl + "&mac=" + mac + "&tsSdnClient=" + serverBean.getClientTime();
        OkGo.getInstance().setRetryCount(0);
        OkGo.get(url).cacheMode(CacheMode.NO_CACHE)
                .writeTimeOut(timeOut)
                .readTimeOut(timeOut)
                .connTimeOut(timeOut)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String str, Call call, Response response) {
                        if (response.code() == 200) {

                            SpeedBean bean = new Gson().fromJson(str, SpeedBean.class);

                            if (null != bean) {
                                serverBean.setServerTime(System.currentTimeMillis());

                                serverBean.setShowResult(true);
                                if (serverBean.getServerTime() - serverBean.getClientTime() > 6000) {
                                    serverBean.setSuccess(false);
                                } else {
                                    serverBean.setSuccess(true);
                                }

                                callback.log("SDN 测速一条的结果：" + serverBean.toString());

                                callback.testSuccess(serverBean);
                            } else {
                                callback.onError("SDN 测速失败返回为空");
                                callback.log("SDN 测速一条的结果：" + serverBean.toString());
                            }
                        } else {
                            callback.onError("SDN 访问服务器失败 访问地址=" + baseUrl + "错误信息:" + response.code());
                            callback.log("SDN 测速一条的结果,访问服务器失败" + serverBean.toString() + "错误信息:" + response.code());
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        serverBean.setSuccess(false);
                        serverBean.setShowResult(true);
                        serverBean.setServerTime(System.currentTimeMillis());
                        callback.log("SDN 测速一条的结果：" + serverBean.toString() + " " + e.getMessage());
                        callback.onError("SDN 访问服务器失败 访问地址=" + baseUrl + "错误信息:" + e.getMessage());
                    }
                });

    }

    /**
     * 发送钉钉消息
     */
    public static void sendDingDing(String url, String message, final SendMsgCallback callback) {
        long ddTimeOut = 10 * 1000;

        OkGo.post(url).connTimeOut(ddTimeOut).readTimeOut(ddTimeOut).writeTimeOut(ddTimeOut).upJson(message).execute(new StringCallback() {
            @Override
            public void onSuccess(String str, Call call, Response response) {
                if (response.code() == 200) {
                    LogUtils.e("sdnManager", "发消息返回结果：" + str);
                    SendMesBean sendMesBean = new Gson().fromJson(str, SendMesBean.class);
                    if (sendMesBean.getErrcode() == 0 && sendMesBean.getErrmsg().equalsIgnoreCase("ok")) {
                        callback.sendSuccess();
                    } else {
                        callback.sendFailed();
                    }
                } else {
                    callback.sendFailed();
                }
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                callback.sendFailed();
            }
        });
    }

    public static void uploadTestLog(Map<String, String> param, SpeedCallback speedCallback) {
        if (null == param) {
            return;
        }


        StringBuilder url = new StringBuilder();
        url.append("http://log.hzdlsoft.com:8081/clog/api.do?apiKey=uploadSdn")
                .append("&")
                .append("sn=")
                .append(param.get("sn"))
                .append("&")
                .append("mac=")
                .append(param.get("mac"))
                .append("&")
                .append("prod=")
                .append(param.get("prod"))
                .append("&")
                .append("version=")
                .append(param.get("version"))
                .append("&")
                .append("tsSdnClient=")
                .append(param.get("tsSdnClient"))
                .append("&")
                .append("cost=")
                .append(param.get("cost"))
                .append("&")
                .append("result=")
                .append(param.get("result"))
                .append("&")
                .append("bestServerId=")
                .append(param.get("bestServerId"));


        speedCallback.log("上传测试评价:" + url.toString());
        long timeOut = 10 * 1000;
        OkGo.get(url.toString()).cacheMode(CacheMode.NO_CACHE)
                .writeTimeOut(timeOut)
                .readTimeOut(timeOut)
                .connTimeOut(timeOut)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String str, Call call, Response response) {

                        LogUtils.e("sdn", "上传日志成功" + str);
                        if (response.code() == 200) {
                        } else {
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        LogUtils.e("sdn", "上传日志失败" + e.getMessage());
                    }
                });

    }
}
