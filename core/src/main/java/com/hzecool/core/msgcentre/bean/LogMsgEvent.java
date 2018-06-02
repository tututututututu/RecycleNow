package com.hzecool.core.msgcentre.bean;

/**
 * 上传日志消息
 * Created by tutu on 2017/4/24.
 */

public class LogMsgEvent {

    /**
     * log_start_date : 获取日志的开始日期
     * log_end_date : 获取日志的结束日期
     */

    private String log_start_date;
    private String log_end_date;

    public String getLog_start_date() {
        return log_start_date;
    }

    public void setLog_start_date(String log_start_date) {
        this.log_start_date = log_start_date;
    }

    public String getLog_end_date() {
        return log_end_date;
    }

    public void setLog_end_date(String log_end_date) {
        this.log_end_date = log_end_date;
    }
}
