package com.hzecool.app.bean.event;

/**
 * Created by tutu on 2017/5/23.
 */

public class ModifyBillingFinishEvent extends BaseEvent{
    /**
     * 这个事件是为了解决 当用户在本单还有数据
     * 但是进入了修改界面,然后选款之后退出修改界面
     * 选款界面的数据没有刷新
     */


    /**
     * 标识是进入还是退出修改界面
     * true  是进入
     * false 是退出
     */
    boolean inModify;


    public ModifyBillingFinishEvent(boolean inModify) {
        this.inModify = inModify;
    }

    public boolean isInModify() {
        return inModify;
    }

    public void setInModify(boolean inModify) {
        this.inModify = inModify;
    }
}
