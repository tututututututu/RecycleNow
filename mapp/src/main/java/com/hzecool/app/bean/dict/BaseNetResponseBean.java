package com.hzecool.app.bean.dict;

/**
 * 实体类基类
 *
 * Created by wangzhiguo on 2017/5/9
 * @author yksoft
 */
public class BaseNetResponseBean{
    private String error;
    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "BaseNetResponseBean{" +
                "error='" + error + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
