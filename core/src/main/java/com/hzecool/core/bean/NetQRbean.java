package com.hzecool.core.bean;

import com.hzecool.app.bean.dict.BaseNetResponseBean;

/**
 * Created by song on 2017/8/29.
 */

public class NetQRbean extends BaseNetResponseBean {

    private String code;
    private String imgUrl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "NetQRbean{" +
                "code='" + code + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
