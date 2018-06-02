package com.hzecool.app.bean.event;

/**
 * 盘点单event
 * Created by wangzhiguo on 2017/7/13
 */
public class InvenActionEvent extends BaseEvent {

    private int position;
    private int itemPosition;
    private String tagId;
    private int action;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public int getItemPosition() {
        return itemPosition;
    }

    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
