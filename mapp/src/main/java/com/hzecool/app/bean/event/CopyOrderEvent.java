package com.hzecool.app.bean.event;

/**
 * 复制订单事件
 * Created by tutu on 2017/5/15.
 */

public class CopyOrderEvent extends BaseEvent {
    private String id;


//    /**
//     * 本单类型 --销售单
//     */
//    public static final int BILLING_TYPE_SELLING = 0;
//    /**
//     * 本单类型 --盘点
//     */
//    public static final int BILLING_TYPE_INVENT = 1;
//    /**
//     * 本单类型 --调出
//     */
//    public static final int BILLING_TYPE_BRING_OUT = 2;

    private int type;

    public CopyOrderEvent(String id, int type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
