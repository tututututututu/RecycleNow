package com.hzecool.app.bean.event;

/**
 * Created by tutu on 2017/5/9.
 */

public class FinishActivityEvent extends BaseEvent {
    public static final int ACTIVITY_MODIFY_BILLING = 1;
    public static final int ACTIVITY_MAIN = 2;

    private int activity;

    public FinishActivityEvent(int activity) {
        this.activity = activity;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }
}
