package com.hzecool.app.bean.event;

/**
 * Created by wangzhiguo on 2017/5/26
 */
public class AddCustomerEvent extends BaseEvent {
    private String id;
    private String name;

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
