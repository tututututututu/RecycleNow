package com.yike.sdn_manager.bean;

/**
 * Created by guige on 2018/5/14.
 * 参数配置
 */
public class ConfigSDN {

    public boolean isDebug = false;

    //此功能在列表获取时决定 不需要配置
    // public boolean OPEN_FUNCTION=true;

    /**
     * 测速超时时间
     */
    public long speedTimeOut = 2 * 1000;
}
