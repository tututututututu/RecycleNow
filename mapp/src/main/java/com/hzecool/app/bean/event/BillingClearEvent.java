package com.hzecool.app.bean.event;

/**
 * 开单界面成功之后清除前一单数据的事件
 * Created by tutu on 2017/5/4.
 */

public class BillingClearEvent extends BaseEvent {

    /**
     * type为 BusinessData.BILLING_TYPE 中的一种
     */
    private int type;

    public BillingClearEvent(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
