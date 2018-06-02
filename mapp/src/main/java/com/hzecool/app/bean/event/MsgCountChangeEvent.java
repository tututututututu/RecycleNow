package com.hzecool.app.bean.event;

/**
 * 客服未读消息数量控制
 *
 * @author song
 * @date 2017/7/20
 */

public class MsgCountChangeEvent extends BaseEvent {
    private int count;

    public MsgCountChangeEvent(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
