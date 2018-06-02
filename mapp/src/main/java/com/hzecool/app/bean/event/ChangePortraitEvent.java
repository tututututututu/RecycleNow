package com.hzecool.app.bean.event;

/**
 * 修改头像事件
 * Created by tutu on 2017/3/16.
 */

public class ChangePortraitEvent {
    String url;

    public ChangePortraitEvent(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
