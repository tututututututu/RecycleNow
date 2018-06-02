package com.yike.sdn_manager.bean;

import java.util.List;

/**
 * Created by guige on 2018/5/11.
 *
 * 服务器请求列表时返回的对象
 */

public class ServerResBean {


    /**
     * slhurl_master : 139.196.124.16:8001
     * sn : 1400221154483
     * socketurl : 101.132.186.4:6061
     * serverList :
     * [{"id":"318","sslurl":"hzdev.hzdlsoft.com:4048","level":"1","modelClass":"DLDynamicModel","name":"批发测试adev1","slhurl":"139.196.124.16:8001"},{"id":"342","sslurl":"192.168.0.113:8081","level":"1","modelClass":"DLDynamicModel","name":"徐骁成本地","slhurl":"192.168.0.113:8081"}]
     * modelClass : DLDynamicModel
     * name : 测试adev1
     * user : com.hzecool.common.iframe.bean.UserBean@1adc26d5
     * interfaceid : cs-getServerURLBySN
     * sslflag : 0
     * enableSDN:是否启用sdn,1启用，0不启用
     *
     */

    private String slhurl_master;
    private String sn;
    private String socketurl;
    private String modelClass;
    private String name;
    private String user;
    private String interfaceid;
    private String sslflag;
    private int enableSDN;
    private List<ServerBean> serverList;
    private int sc_sdn_timeout;

    public int getSc_sdn_timeout() {
        return sc_sdn_timeout;
    }

    public void setSc_sdn_timeout(int sc_sdn_timeout) {
        this.sc_sdn_timeout = sc_sdn_timeout;
    }

    public int getEnableSDN() {
        return enableSDN;
    }

    public void setEnableSDN(int enableSDN) {
        this.enableSDN = enableSDN;
    }

    public String getSlhurl_master() {
        return slhurl_master;
    }

    public void setSlhurl_master(String slhurl_master) {
        this.slhurl_master = slhurl_master;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSocketurl() {
        return socketurl;
    }

    public void setSocketurl(String socketurl) {
        this.socketurl = socketurl;
    }

    public String getModelClass() {
        return modelClass;
    }

    public void setModelClass(String modelClass) {
        this.modelClass = modelClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getInterfaceid() {
        return interfaceid;
    }

    public void setInterfaceid(String interfaceid) {
        this.interfaceid = interfaceid;
    }

    public String getSslflag() {
        return sslflag;
    }

    public void setSslflag(String sslflag) {
        this.sslflag = sslflag;
    }

    public List<ServerBean> getServerList() {
        return serverList;
    }

    public void setServerList(List<ServerBean> serverList) {
        this.serverList = serverList;
    }

    @Override
    public String toString() {
        return "ServerResBean{" +
                "slhurl_master='" + slhurl_master + '\'' +
                ", sn='" + sn + '\'' +
                ", socketurl='" + socketurl + '\'' +
                ", modelClass='" + modelClass + '\'' +
                ", name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", interfaceid='" + interfaceid + '\'' +
                ", sslflag='" + sslflag + '\'' +
                ", enableSDN=" + enableSDN +
                ", serverList=" + serverList +
                ", sc_sdn_timeout=" + sc_sdn_timeout +
                '}';
    }
}
