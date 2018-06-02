package com.tt.recyclenow.app;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.hzecool.core.base.BaseApp;

/**
 * @author tutu
 * @time 2018/6/2
 */

public class RealApp extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();

    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
