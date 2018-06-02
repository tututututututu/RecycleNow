package com.hzecool.app.bean.event;

/**
 * Created by tutu on 2017/5/5.
 */

public class ChangeBillingTypeEvent extends BaseEvent {
    private int type;

    public ChangeBillingTypeEvent(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
