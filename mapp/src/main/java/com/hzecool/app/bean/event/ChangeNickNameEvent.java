package com.hzecool.app.bean.event;

/**
 * Discribe: 修改昵称事件
 * Created by tutu on 2017/3/17.
 */

public class ChangeNickNameEvent extends BaseEvent {
    String nickName;


    public ChangeNickNameEvent(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
