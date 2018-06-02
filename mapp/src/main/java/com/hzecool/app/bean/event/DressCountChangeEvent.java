package com.hzecool.app.bean.event;

import java.math.BigDecimal;

/**
 * 款式数量变化事件  用于主界面角标变化
 *
 * @author tutu
 * @date 2017/5/3
 */

public class DressCountChangeEvent extends BaseEvent {
    private BigDecimal count;

    public DressCountChangeEvent(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
