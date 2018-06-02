package com.hzecool.app.bean.event;

/**
 * 修改默认门店事件
 * Created by tutu on 2017/3/13.
 */

public class CheakDefaultShopEvent extends BaseEvent {
    String openId;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CheakDefaultShopEvent(String openId, String name) {
        this.openId = openId;
        this.name = name;
    }

    public CheakDefaultShopEvent(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "CheakDefaultShopEvent{" +
                "openId='" + openId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
