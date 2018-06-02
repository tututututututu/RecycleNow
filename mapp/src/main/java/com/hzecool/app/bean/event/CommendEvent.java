package com.hzecool.app.bean.event;

/**
 * Created by tutu on 2017/4/7.
 * 所有只是一个命令类事件,不需要额外的参数事件
 * 比如上传日志命令
 */

public class CommendEvent extends BaseEvent {
    public static final int COMMEND_UPLOAD_LOG = 1;


    private int commend;

    public CommendEvent(int commend) {
        this.commend = commend;
    }


    public int getCommend() {
        return commend;
    }

    public void setCommend(int commend) {
        this.commend = commend;
    }
}
