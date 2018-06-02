package com.hzecool.app.bean.event;

/**
 * Created by song on 2017/11/15.
 */

public class RefreshDwxxEvent extends BaseEvent {

    private boolean isRefresh;

    public RefreshDwxxEvent(boolean isRefresh) {
        this.isRefresh = isRefresh;
    }

    public boolean isRefresh() {
        return isRefresh;
    }

    public void setRefresh(boolean refresh) {
        isRefresh = refresh;
    }
}
