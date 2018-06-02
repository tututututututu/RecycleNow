package com.hzecool.app.bean.event;

/**
 * 返回主页时的index
 * Created by wangzhiguo on 2017/5/3
 */
public class ChangeTabEvent {
    private int tabIndex;

    public ChangeTabEvent(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    public int getTabIndex() {
        return tabIndex;
    }

    public void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }
}
