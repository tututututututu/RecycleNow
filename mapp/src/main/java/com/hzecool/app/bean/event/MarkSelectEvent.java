package com.hzecool.app.bean.event;

/**
 * 标签event
 * Created by wangzhiguo on 2017/5/9
 * @author yksoft
 */
public class MarkSelectEvent extends BaseEvent {
    private String id;
    private String name;

    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
