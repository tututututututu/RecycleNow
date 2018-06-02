package com.yike.sdn_manager.main;

import com.yike.sdn_manager.bean.ServerBean;
import com.yike.sdn_manager.bean.ServerResBean;
import com.yike.sdn_manager.callback.SpeedCallback;

import java.util.Map;

/**
 * Created by guige on 2018/5/9.
 *
 * SDN 的接口
 */

public interface IManager {

    void loadServerList(ServerResBean serverResBean, SpeedCallback speedCallback);

    void onFailed(String msg);

    void testSpeed(ServerBean bean,SpeedCallback speedCallback);

    void testFailed(String msg,ServerBean bean,SpeedCallback speedCallback);

    void sendMesSuccess();

    void sendFailed();
}
