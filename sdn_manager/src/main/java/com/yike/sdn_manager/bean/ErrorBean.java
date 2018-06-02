package com.yike.sdn_manager.bean;

/**
 * Created by guige on 2018/5/12.
 *  选择失败时的回调对象
 */

public class ErrorBean {

    /***
     * code 0: 成功
     * code 1:获取服务列表地址错误
     * code 2:mac地址为null
     * code 3:获取服务列表为空
     * code 4: 发送消息的地址为空
     * code 5: dingding 消息发送成功
     * code 6: dingding 消息发送失败
     * code 8: 功能被关闭
     */

    private int code;

    private String message;

    public ErrorBean() {
    }

    public ErrorBean(int code, String message) {
        this.code = code;
        this.message = message;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
