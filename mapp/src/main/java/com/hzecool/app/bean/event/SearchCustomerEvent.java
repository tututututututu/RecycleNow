package com.hzecool.app.bean.event;

/**
 * Created by wangzhiguo on 2017/8/11
 */
public class SearchCustomerEvent extends BaseEvent {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
