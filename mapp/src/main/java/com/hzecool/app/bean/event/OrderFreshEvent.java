package com.hzecool.app.bean.event;

/**
 * @author tutu
 * @time 2018/3/6
 * 历史订单刷新事件
 */

public class OrderFreshEvent extends BaseEvent {

    /**
     * 订单类型
     */
    private int orderType;

    public OrderFreshEvent(int orderType) {
        this.orderType = orderType;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }
}
