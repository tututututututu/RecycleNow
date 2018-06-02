package com.hzecool.app.bean.event;

/**
 * Created by song on 2017/8/10.
 */

public class PicNumEvent extends BaseEvent {
    private int num;

    public PicNumEvent(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
