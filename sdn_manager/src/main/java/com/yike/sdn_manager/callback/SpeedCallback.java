package com.yike.sdn_manager.callback;

import com.yike.sdn_manager.bean.ServerBean;

/**
 *
 * @author guige
 * @date 2018/5/9
 *  网速回调的
 */

public interface SpeedCallback extends ErrorCallback{

    void testSuccess(ServerBean bean);
    void log(String msg);

}
