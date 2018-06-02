package com.hzecool.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 款式
 *
 * @author tutu
 * @date 2017/4/6
 */

@Entity
public class ExpBean {
    /**
     * id
     */
    @Unique
    private String id;

    @Generated(hash = 213448515)
    public ExpBean(String id) {
        this.id = id;
    }

    @Generated(hash = 860351556)
    public ExpBean() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
