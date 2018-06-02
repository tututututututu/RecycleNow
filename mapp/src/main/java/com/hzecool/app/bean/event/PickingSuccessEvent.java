package com.hzecool.app.bean.event;

/**
 * Created by song on 2017/11/1.
 */

public class PickingSuccessEvent extends BaseEvent {

    private int CheckedNum;

    public PickingSuccessEvent(int checkedNum) {
        CheckedNum = checkedNum;
    }


    public int getCheckedNum() {
        return CheckedNum;
    }

    public void setCheckedNum(int checkedNum) {
        CheckedNum = checkedNum;
    }
}
