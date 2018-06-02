package com.hzecool.app.bean.event;

/**
 * Created by song on 2017/11/3.
 */

public class PickFailEvent extends BaseEvent {
    private int flag;

    public PickFailEvent(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
