package com.hzecool.core.bean;

import com.hzecool.app.bean.dict.BaseNetResponseBean;

/**
 *
 * @author slh
 * @date 2017/3/6
 */

public class ResponseStringBean extends BaseNetResponseBean {
    /**
     * val : 1
     */

    private String val;
    private String content;
    private String code;
    private String dwid;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDwid() {
        return dwid;
    }

    public void setDwid(String dwid) {
        this.dwid = dwid;
    }

    @Override
    public String toString() {
        return "ResponseStringBean{" +
                "val='" + val + '\'' +
                ", content='" + content + '\'' +
                ", code='" + code + '\'' +
                ", dwid='" + dwid + '\'' +
                '}';
    }
}
