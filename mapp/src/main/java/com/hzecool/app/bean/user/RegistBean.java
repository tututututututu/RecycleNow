package com.hzecool.app.bean.user;

import com.hzecool.app.bean.dict.BaseNetResponseBean;

/**
 * @author tutu
 * @time 2018/1/23
 */

public class RegistBean extends BaseNetResponseBean{

    /**
     * regcode : 注册码
     * begindate : 设备启用时间
     * sn : 客户完整编号sn
     * enddate : 设备到期时间
     * protype : 企业protype
     * socketurl : 消息服务器地址
     * keychain : 注册标识
     */

    private String regcode;
    private String begindate;
    private String sn;
    private String enddate;
    private String protype;
    private String socketurl;
    private String keychain;

    public String getRegcode() {
        return regcode;
    }

    public void setRegcode(String regcode) {
        this.regcode = regcode;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype;
    }

    public String getSocketurl() {
        return socketurl;
    }

    public void setSocketurl(String socketurl) {
        this.socketurl = socketurl;
    }

    public String getKeychain() {
        return keychain;
    }

    public void setKeychain(String keychain) {
        this.keychain = keychain;
    }

    @Override
    public String toString() {
        return "RegistBean{" +
                "regcode='" + regcode + '\'' +
                ", begindate='" + begindate + '\'' +
                ", sn='" + sn + '\'' +
                ", enddate='" + enddate + '\'' +
                ", protype='" + protype + '\'' +
                ", socketurl='" + socketurl + '\'' +
                ", keychain='" + keychain + '\'' +
                '}';
    }
}
