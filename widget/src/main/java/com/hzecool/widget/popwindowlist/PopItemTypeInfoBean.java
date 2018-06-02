package com.hzecool.widget.popwindowlist;

/**
 *
 * @author 47066
 * @date 2017/10/30
 */

public class PopItemTypeInfoBean {
    private String name;
    private int type;

    public PopItemTypeInfoBean(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PopItemTypeInfoBean{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
