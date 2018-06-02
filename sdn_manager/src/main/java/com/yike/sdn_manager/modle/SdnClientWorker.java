package com.yike.sdn_manager.modle;

import com.yike.sdn_manager.bean.ServerBean;

/**
 * Created by guige on 2018/5/10.
 *
 * 测试网络速度的线程对象
 */

public class SdnClientWorker implements Runnable{


    private ServerBean serverBean;

    public SdnClientWorker(ServerBean serverBean) {
        this.serverBean=serverBean;
    }

    @Override
    public void run() {


    }
}
