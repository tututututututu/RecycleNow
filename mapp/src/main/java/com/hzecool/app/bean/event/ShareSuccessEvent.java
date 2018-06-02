package com.hzecool.app.bean.event;

/**
 * 分享成功事件
 * Created by tutu on 2017/3/12.
 */

public class ShareSuccessEvent extends BaseEvent {
    boolean success;
    String id;

    public ShareSuccessEvent(boolean success, String id) {
        this.success = success;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ShareSuccessEvent{" +
                "success=" + success +
                ", id='" + id + '\'' +
                '}';
    }
}
