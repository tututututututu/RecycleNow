package com.yike.sdn_manager.callback;

import com.yike.sdn_manager.bean.ServerBean;
import com.yike.sdn_manager.bean.ServerResBean;

import java.util.List;

/**
 * Created by guige on 2018/5/9.
 *
 * 获取服务器列表的回调
 */

public interface ServerListCallback extends ErrorCallback{

    void loadServerList(ServerResBean serverResBean);

}
