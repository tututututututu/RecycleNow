package com.hzecool.app.bean.event;


import com.hzecool.app.bean.user.PickingSkuBean;

/**
 *
 * @author song
 * @date 2017/11/3
 */

public class PickingSkuEvent extends BaseEvent {

    private PickingSkuBean mLDressSkuBean;

    public PickingSkuEvent(PickingSkuBean LDressSkuBean) {
        mLDressSkuBean = LDressSkuBean;
    }

    public PickingSkuBean getLDressSkuBean() {
        return mLDressSkuBean;
    }

    public void setLDressSkuBean(PickingSkuBean LDressSkuBean) {
        mLDressSkuBean = LDressSkuBean;
    }
}
