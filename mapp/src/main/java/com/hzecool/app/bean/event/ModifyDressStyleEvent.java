package com.hzecool.app.bean.event;

/**
 * Created by tutu on 2017/6/6.
 */

/**
 * 是否修改了一个款式的详情
 * 用在: 修改订单时  已打印的订单不允许修改中,用来判断款式详情是否被修改过
 */
public class ModifyDressStyleEvent {
    private boolean isModify;

    public ModifyDressStyleEvent(boolean isModify) {
        this.isModify = isModify;
    }

    public boolean isModify() {
        return isModify;
    }

    public void setModify(boolean modify) {
        isModify = modify;
    }
}
