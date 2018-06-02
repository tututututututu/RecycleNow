package com.yike.sdn_manager.bean;

/**
 * Created by guige on 2018/5/9.
 * <p>
 * 服务的对象
 */

public class ServerBean {

    /**
     * "id":81,"name":"hz杭州-a01","slhurl":"223.6.248.236:8081",
     * "sslurl":"ah1.slh.hzdlsoft.com:8481","level":"1"
     */


    private String id;
    private String name;
    private String slhurl;
    private String sslurl;
    private int level;


    /**
     * 客户端时间
     */
    private long clientTime;
    /**
     * 服务器响应时间
     */
    private long serverTime;

    private boolean success;

    private boolean showResult;

    public boolean isShowResult() {
        return showResult;
    }

    public void setShowResult(boolean showResult) {
        this.showResult = showResult;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ServerBean() {
    }

    public ServerBean(String id, String name, String slhurl, String sslurl, int level) {
        this.id = id;
        this.name = name;
        this.slhurl = slhurl;
        this.sslurl = sslurl;
        this.level = level;
    }

    public long getClientTime() {
        return clientTime;
    }

    public void setClientTime(long clientTime) {
        this.clientTime = clientTime;
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlhurl() {
        return slhurl;
    }

    public void setSlhurl(String slhurl) {
        this.slhurl = slhurl;
    }

    public String getSslurl() {
        return sslurl;
    }

    public void setSslurl(String sslurl) {
        this.sslurl = sslurl;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        try {

            StringBuilder sb = new StringBuilder();
            sb.append("ServerBean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", slhurl='" + slhurl + '\'' +
                    ", sslurl='" + sslurl + '\'' +
                    ", level=" + level +
                    ", clientTime=" + clientTime +
                    ", serverTime=" + serverTime +
                    '}');

            if (showResult) {
                sb.append(" 耗时:" + (getServerTime() - getClientTime()) + (isSuccess() ? "  访问成功" : "  访问失败"));
            }

            return sb.toString();
        } catch (Exception e) {
        }
        return "";
    }
}
