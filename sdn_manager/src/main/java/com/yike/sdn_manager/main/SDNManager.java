package com.yike.sdn_manager.main;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.lzy.okgo.OkGo;
import com.yike.sdn_manager.R;
import com.yike.sdn_manager.bean.ConfigSDN;
import com.yike.sdn_manager.bean.ErrorBean;
import com.yike.sdn_manager.bean.ServerBean;
import com.yike.sdn_manager.bean.ServerResBean;
import com.yike.sdn_manager.callback.SdnCallback;
import com.yike.sdn_manager.callback.SpeedCallback;
import com.yike.sdn_manager.modle.ServerModel;
import com.yike.sdn_manager.utils.LogUtils;
import com.yike.sdn_manager.utils.ResUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author guige
 * @date 2018/5/9
 * SDN 调用管理
 */

public class SDNManager implements IManager {


    private static final String TAG = "sdnManager";

    private SDNManager() {
    }

    private volatile static SDNManager sdnManager = new SDNManager();

    private ServerPresenter serverPresenter;
    private long currentTime = 0;
    private Map<String, String> configMap;
    /**
     * 测速返回的服务端列表
     */
    private List<ServerBean> serverBeanLists;
    private int max_Server;
    private SdnCallback sdnCallback;
    private Context context;
    private ConfigSDN configSDN;

    /**
     * 服务器返回的1级和2级列表
     */
    private List<ServerBean> server2Class;
    private List<ServerBean> server1Class;
    private boolean isHttps;


    public static SDNManager getInstance() {
        return sdnManager;
    }

    public void init(Context context, boolean isHttps) {
        this.context = context;
        OkGo.getInstance().init((Application) context.getApplicationContext());
        if (serverPresenter == null) {
            serverPresenter = new ServerPresenter(this);
        }
        this.isHttps = isHttps;
    }

    /**
     * @param configSDN 参数配置
     */
    public void setConfig(ConfigSDN configSDN) {
        if (configSDN == null) {
            this.configSDN = new ConfigSDN();
        } else {
            this.configSDN = configSDN;
        }
        setDebug(this.configSDN.isDebug);
    }

    /**
     * 开始测试的
     *
     * @param map         传递参数
     * @param sdnCallback 回调
     *                    <p>
     *                    map: baseUrl  String  获取服务器的接口地址
     *                    mac      String  mac地址
     *                    sendMesUrl  String 发送到钉钉的地址
     *                    sn       String   用户sn
     *                    printhead String  门店
     */
    public void startCheck(Map<String, String> map, SdnCallback sdnCallback, ServerResBean bean, SpeedCallback speedCallback) {

        if (map == null || null == sdnCallback) {
            return;
        }
        //防止短时间内重复选择
        long time = System.currentTimeMillis();
        if (time - currentTime < 4 * 1000) {
            speedCallback.log("防止4秒内重复检测,拦截检测");
            return;
        }
        currentTime = time;

        configMap = map;
        this.sdnCallback = sdnCallback;
        if (TextUtils.isEmpty(map.get("baseUrl"))) {
            failedCallback(1);
            return;
        }
        if (TextUtils.isEmpty(map.get("mac"))) {
            failedCallback(2);
            return;
        }

//        serverPresenter.loadServerList(map.get("baseUrl"));
        loadServerList(bean, speedCallback);
    }

    /**
     * 获取服务器的列表
     *
     * @param bean
     */

    @Override
    public void loadServerList(ServerResBean bean, SpeedCallback speedCallback) {

        if (null == bean) {
            failedCallback(1);
            return;
        }
        //测速功能关闭
        if (bean.getEnableSDN() == 0) {
            failedCallback(8);
            return;
        }
        List<ServerBean> lists = bean.getServerList();
        if (null == lists || lists.size() < 1) {
            speedCallback.log("SDN OA服务器列表为空");
            failedCallback(3);
            return;
        }
        if (server1Class != null) {
            server1Class.clear();
        }
        if (server2Class != null) {
            server2Class.clear();
        }

        for (ServerBean serverBean : lists) {

            if (1 == serverBean.getLevel()) {
                if (server1Class == null) {
                    server1Class = new ArrayList<>();
                }
                server1Class.add(serverBean);
            }
            if (2 == serverBean.getLevel()) {
                if (server2Class == null) {
                    server2Class = new ArrayList<>();
                }
                server2Class.add(serverBean);
            }
        }
        testBast1Server(speedCallback);

    }

    /**
     * 测试1级的服务器
     */
    private void testBast1Server(SpeedCallback speedCallback) {
        if (server1Class == null || server1Class.isEmpty()) {
            testBast2Server(speedCallback);
        } else {
            speedCallback.log("开始测试level=1的服务器");
            startTest(server1Class, speedCallback);
        }
    }

    /**
     * 测试2级的服务器
     */
    private void testBast2Server(SpeedCallback speedCallback) {
        if (server2Class == null || server2Class.isEmpty()) {
            sendDingDingMes(speedCallback);
        } else {
            speedCallback.log("开始测试level=2的服务器");
            startTest(server2Class, speedCallback);
        }
    }

    /**
     * 开始测试
     */
    private void startTest(List<ServerBean> lists, SpeedCallback speedCallback) {
        if (serverBeanLists != null) {
            serverBeanLists.clear();
        }
        max_Server = lists.size();
        //开始选择
        for (ServerBean serverBean : lists) {
            serverPresenter.testSpeed(isHttps, serverBean, configMap.get("mac"), configSDN.speedTimeOut, speedCallback);
        }
    }


    @Override
    public void onFailed(String msg) {
        LogUtils.i(TAG, msg);
        failedCallback(1);
    }


    /**
     * 测速结果的回调
     */
    @Override
    public void testSpeed(ServerBean bean, SpeedCallback speedCallback) {
        bean.setSuccess(true);
        addServer(bean, speedCallback);
    }

    /**
     * 测速失败
     */
    @Override
    public void testFailed(String msg, ServerBean bean, SpeedCallback speedCallback) {
        LogUtils.i(TAG, msg);
        bean.setSuccess(false);
        addServer(bean, speedCallback);
    }

    /***
     * 发送钉钉消息成功
     */
    @Override
    public void sendMesSuccess() {
        failedCallback(5);

    }

    @Override
    public void sendFailed() {
        failedCallback(6);
    }

    /**
     * 失败回调统一处理
     */
    private void failedCallback(int code) {
        if (sdnCallback != null) {
            String message;
            switch (code) {
                case 1:
                    message = ResUtils.getResString(context, R.string.server_url_error);
                    break;
                case 2:
                    message = ResUtils.getResString(context, R.string.mac_null);
                    break;
                case 3:
                    message = ResUtils.getResString(context, R.string.server_list_null);
                    break;
                case 4:
                    message = ResUtils.getResString(context, R.string.dingding_url_null);
                    break;
                case 5:
                    message = ResUtils.getResString(context, R.string.dingding_send_success);
                    break;
                case 6:
                    message = ResUtils.getResString(context, R.string.dingding_send_failed);
                    break;
                case 8:
                    message = ResUtils.getResString(context, R.string.function_close);
                    break;
                default:
                    message = ResUtils.getResString(context, R.string.select_success);
                    break;

            }
            sdnCallback.onFailed(new ErrorBean(code, message));
        }
    }

    /**
     * 添加测速后的服务器
     */
    private void addServer(ServerBean bean, SpeedCallback speedCallback) {
        if (null == serverBeanLists) {
            serverBeanLists = new ArrayList<>();
        }
        if (serverBeanLists.size() == max_Server) {

            speedCallback.log("测速结果如下:");

            for (ServerBean serverBeanList : serverBeanLists) {
                serverBeanList.setShowResult(true);
            }
            speedCallback.log(serverBeanLists.toString());

            serverBeanLists.clear();
        }
        serverBeanLists.add(bean);
        if (serverBeanLists.size() == max_Server) {
            speedCallback.log("测速结果如下:");
            for (ServerBean serverBeanList : serverBeanLists) {
                serverBeanList.setShowResult(true);
            }

            speedCallback.log(serverBeanLists.toString());

            ServerBean bastBean = getBastServer(serverBeanLists);


            if (bastBean != null) {
                bastBean.setShowResult(true);
                speedCallback.log("选择最优线路:" + bastBean.toString());
            }




            if (null == bastBean) {
                if (bean.getLevel() == 2) {
                    //二级线路也没有 发消息到钉钉
                    speedCallback.log("没有最优线路,发钉钉消息,上传日志");
                    sendDingDingMes(speedCallback);
                } else {
                    speedCallback.log("level=1的没有最优线路");
                    testBast2Server(speedCallback);
                }
            } else {
                Map<String,String> params = getResultMap();
                params.put("result",String.valueOf(1));
                params.put("bestServerId",bastBean.getId());
                ServerModel.uploadTestLog(params,speedCallback);
                sdnCallback.onSuccess(bastBean);
            }
        }
    }


    private Map<String,String> getResultMap(){

        Map<String,String> params = new HashMap<>();
        params.put("sn",configMap.get("sn"));
        params.put("mac",configMap.get("mac"));
        params.put("prod",configMap.get("productName"));
        params.put("version",ResUtils.getAppVersionName(context));
        params.put("tsSdnClient",String.valueOf(currentTime));
        params.put("cost",String.valueOf(System.currentTimeMillis() - currentTime));

        return params;
    }


    /***
     *  发消息到钉钉
     * @param speedCallback
     */
    private void sendDingDingMes(SpeedCallback speedCallback) {
        if (TextUtils.isEmpty(configMap.get("sendMesUrl"))) {
            failedCallback(4);
            return;
        }

        String productName = "";
        if (TextUtils.isEmpty(configMap.get("productName"))) {
            productName = "Android版店员助手";
        } else {
            productName = configMap.get("productName");
        }

        SimpleDateFormat formattwo = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        String nowtime = formattwo.format(System.currentTimeMillis());

        String message = "{\"msgtype\": \"text\",\"text\": {\"content\":\"" + nowtime + ",\n" + productName + "线路选择失败," +
                "\nsn:" + configMap.get("sn") + ",\nmac:" + configMap.get("mac") + ",\nprinthead:" +
                configMap.get("printhead") + ",\n本次选择共耗时：" + (System.currentTimeMillis() - currentTime) + "ms\"}}";
        serverPresenter.sendDingDing(configMap.get("sendMesUrl"), message);

        Map<String,String> params = getResultMap();
        params.put("result",String.valueOf(0));
        params.put("bestServerId","");
        ServerModel.uploadTestLog(params,speedCallback);
    }

    /**
     * 获取最优选择
     */
    private ServerBean getBastServer(List<ServerBean> serverBeanLists) {
        ServerBean bastBean = null;

        for (ServerBean bean : serverBeanLists) {
            if (bean.getServerTime() <= 0 || !bean.isSuccess()) {
                continue;
            }
            if (bastBean == null) {
                bastBean = bean;
                continue;
            }
            if (bean.getServerTime() - bean.getClientTime() <
                    bastBean.getServerTime() - bastBean.getClientTime()) {
                bastBean = bean;
            }

        }
        return bastBean;

    }


    private void setDebug(boolean isDebug) {
        LogUtils.isDebug = isDebug;
    }
}
