package com.hzecool.app.bean.event;

/**
 * Created by song on 2017/11/4.
 */

public class PickChooseBTEvent extends BaseEvent {
    private int chooseBT;

    public PickChooseBTEvent(int chooseBT) {
        this.chooseBT = chooseBT;
    }

    public int getChooseBT() {
        return chooseBT;
    }

    public void setChooseBT(int chooseBT) {
        this.chooseBT = chooseBT;
    }
}
