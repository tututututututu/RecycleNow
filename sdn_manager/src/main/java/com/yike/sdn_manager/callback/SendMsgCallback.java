package com.yike.sdn_manager.callback;

/**
 * Created by guige on 2018/5/9.
 *  发送钉钉消息的回调
 */

public interface SendMsgCallback {

    void sendSuccess();
    void sendFailed();

}
