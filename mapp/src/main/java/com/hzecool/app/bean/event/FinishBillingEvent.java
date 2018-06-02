package com.hzecool.app.bean.event;

/**
 *
 * @author tutu
 * @date 2017/7/31
 */

public class FinishBillingEvent extends BaseEvent {
    /**
     * 订单类型
     */
    private int billingType;

    public FinishBillingEvent(int billingType) {
        this.billingType = billingType;
    }

    public int getBillingType() {
        return billingType;
    }

    public void setBillingType(int billingType) {
        this.billingType = billingType;
    }

    @Override
    public String toString() {
        return "FinishBillingEvent{" +
                "billingType=" + billingType +
                '}';
    }
}
