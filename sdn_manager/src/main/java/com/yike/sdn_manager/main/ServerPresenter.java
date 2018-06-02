package com.yike.sdn_manager.main;

import com.yike.sdn_manager.bean.ServerBean;
import com.yike.sdn_manager.bean.ServerResBean;
import com.yike.sdn_manager.callback.SendMsgCallback;
import com.yike.sdn_manager.callback.ServerListCallback;
import com.yike.sdn_manager.callback.SpeedCallback;
import com.yike.sdn_manager.modle.ServerModel;
import com.yike.sdn_manager.utils.LogUtils;

/**
 * Created by guige on 2018/5/9.
 * <p>
 * presenter
 */

public class ServerPresenter {


    private IManager iManager;

    public ServerPresenter(IManager iManager) {
        this.iManager = iManager;
    }


    /***
     * 获取服务列表
     * @param baseUrl url
     */
    public void loadServerList(String baseUrl) {
        LogUtils.i("获取服务器的地址", baseUrl);
        ServerModel.getServerList(baseUrl, new ServerListCallback() {
            @Override
            public void loadServerList(ServerResBean bean) {
                //iManager.loadServerList(bean);
            }

            @Override
            public void onError(String message) {
                iManager.onFailed(message);

            }
        });

    }


    /**
     * 测试网速
     *
     * @param serverBean 服务对象
     * @param mac        mac
     */
    public void testSpeed(boolean isHttps, final ServerBean serverBean, String mac, long timeOut, final SpeedCallback speedCallback) {

        if (null == serverBean) {
            LogUtils.i("测试网速", "服务对象为null");
            return;
        }
        String url = "http://" + (isHttps ? serverBean.getSslurl() : serverBean.getSlhurl()) + "/slh/check.do?svc=checkSdn";
        ServerModel.testSpeed(url, mac, serverBean, timeOut, new SpeedCallback() {
            @Override
            public void testSuccess(ServerBean bean) {
                bean.setSuccess(true);
                iManager.testSpeed(bean, speedCallback);
            }

            @Override
            public void log(String msg) {
                speedCallback.log(msg);
            }

            @Override
            public void onError(String message) {
                serverBean.setSuccess(false);
                serverBean.setServerTime(System.currentTimeMillis());
                iManager.testFailed(message, serverBean, speedCallback);
            }
        });

    }

    public void sendDingDing(String url, String message) {
        ServerModel.sendDingDing(url, message, new SendMsgCallback() {
            @Override
            public void sendSuccess() {
                iManager.sendMesSuccess();
            }

            @Override
            public void sendFailed() {
                iManager.sendFailed();
            }
        });
    }



}
