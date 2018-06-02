package com.yike.sdn_manager.bean;

/**
 * Created by guige on 2018/5/10.
 * <p>
 * 发送钉钉消息返回的结果
 */

public class SendMesBean {

    private String errmsg;
    private int errcode;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
}
