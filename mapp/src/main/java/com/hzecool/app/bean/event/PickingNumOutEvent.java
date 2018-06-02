package com.hzecool.app.bean.event;

/**
 * Created by song on 2017/11/2.
 */

public class PickingNumOutEvent extends BaseEvent {

    private String NumFlag;

    public PickingNumOutEvent(String numFlag) {
        NumFlag = numFlag;
    }

    public String getNumFlag() {
        return NumFlag;
    }

    public void setNumFlag(String numFlag) {
        NumFlag = numFlag;
    }
}
