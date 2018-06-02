package com.hzecool.core.bean;

/**
 * 请求参数
 * Created by tutu on 2017/3/1.
 */

public class JsonParamBean {
    /**
     * bdomainCode : staffAssist
     * protocol : https
     * unitId : 1111
     */

    private String bdomainCode;
    private String protocol;
    private String unitId;
    private String mobile;
    private String loginName;
    private String captcha;
    private String userName;
    private String password;
    private String nickName;


    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBdomainCode() {
        return bdomainCode;
    }

    public void setBdomainCode(String bdomainCode) {
        this.bdomainCode = bdomainCode;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
}
