package com.hzecool.app.bean.event;

/**
 * 加载草稿事件
 * Created by tutu on 2017/5/11.
 */

public class LoadDraftEvent extends BaseEvent {

    private String contentJson;
    private int billingType;

    public LoadDraftEvent(String contentJson, int billingType) {
        this.contentJson = contentJson;
        this.billingType = billingType;
    }

    public int getBillingType() {
        return billingType;
    }

    public void setBillingType(int billingType) {
        this.billingType = billingType;
    }

    public String getContentJson() {
        return contentJson;
    }

    public void setContentJson(String contentJson) {
        this.contentJson = contentJson;
    }
}
