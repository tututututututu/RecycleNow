package com.hzecool.app.bean.event;

/**
 * Created by wangzhiguo on 2017/4/19.
 */

public class ChangeBillTypeEvent extends BaseEvent {

    private boolean isChange;

    public boolean isChange() {
        return isChange;
    }

    public void setChange(boolean change) {
        isChange = change;
    }
}
