package com.hzecool.app.bean.event;

/**
 * 删除标签时发送的事件
 * Created by wangzhiguo on 2017/6/9
 */
public class MarkDeleteEvent extends BaseEvent {
    private String tagId;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }
}
