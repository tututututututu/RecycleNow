package com.hzecool.core.msgcentre.bean;

/**
 * 同步数据消息
 * Created by tutu on 2017/4/24.
 */

public class SynDataMsgEvent {

    /**
     * val : 数据表
     */

    private String val;

    public SynDataMsgEvent() {
    }

    public SynDataMsgEvent(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "SynDataMsgEvent{" +
                "val='" + val + '\'' +
                '}';
    }
}
