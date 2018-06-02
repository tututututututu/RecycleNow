package com.hzecool.app.bean.event;

/**
 * Created by wangzhiguo on 2017/7/13
 */
public class TransActionEvent extends BaseEvent {

    private String id;
    private String flag;
    private int position;
    private int action;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
