package com.yike.sdn_manager.bean;

/**
 * Created by guige on 2018/5/10.
 * <p>
 * 测速结果的对象
 */

public class SpeedBean {

    /**
     * {"mac":"","tsSdnClient":"","tsSdnServer":""}
     */

    private String mac;
    /**
     * 请求发出的时间戳
     */
    private long tsSdnClient;
    /***
     * 响应的时间戳
     */
    private long tsSdnServer;

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public long getTsSdnClient() {
        return tsSdnClient;
    }

    public void setTsSdnClient(long tsSdnClient) {
        this.tsSdnClient = tsSdnClient;
    }

    public long getTsSdnServer() {
        return tsSdnServer;
    }

    public void setTsSdnServer(long tsSdnServer) {
        this.tsSdnServer = tsSdnServer;
    }
}
