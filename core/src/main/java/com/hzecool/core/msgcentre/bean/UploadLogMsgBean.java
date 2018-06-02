package com.hzecool.core.msgcentre.bean;

/**
 *
 * @author 47066
 * @date 2017/11/9
 */

public class UploadLogMsgBean {
    private String log_date;
    private String val;

    public String getLog_date() {
        return log_date;
    }

    public void setLog_date(String log_date) {
        this.log_date = log_date;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "UploadLogMsgBean{" +
                "log_date='" + log_date + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}
