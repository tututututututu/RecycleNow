package com.hzecool.app.bean.event;

/**
 * Created by tutu on 2017/6/15.
 * 切换历史订单类型事件
 */

public class ChangeOrderTypeEvent {
    private int orderType;

    public ChangeOrderTypeEvent(int orderType) {
        this.orderType = orderType;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }
}
