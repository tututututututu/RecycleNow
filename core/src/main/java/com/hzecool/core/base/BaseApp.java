package com.hzecool.core.base;

import android.app.Application;
import android.content.Intent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hzecool.app.data.AppData;
import com.hzecool.common.utils.ConvertUtils;
import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.common.utils.Utils;
import com.hzecool.core.R;
import com.hzecool.core.crash.CrashHander;
import com.hzecool.core.log.L;
import com.hzecool.core.log.LocalLogManager;
import com.hzecool.core.manager.ActivityStack;
import com.hzecool.core.msgcentre.MsgCentre;
import com.hzecool.core.net.LoggingInterceptor;
import com.hzecool.core.sp.FinalSPOperation;
import com.hzecool.db.manager.DaoManager;
import com.hzecool.widget.loadingLayout.LoadingLayout;
import com.lzx.musiclibrary.manager.MusicManager;
import com.lzx.musiclibrary.utils.BaseUtil;
import com.lzy.okgo.OkGo;
import com.squareup.leakcanary.LeakCanary;

import static com.hzecool.app.data.AppData.LOG_DEBUG;

/**
 * BaseApp core层Application
 *
 * @author tutu
 * @date 2017/3/3
 */

public class BaseApp extends Application {
    private static BaseApp myApplication = null;

    public static BaseApp getApplication() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        //初始化utils中的Context
        Utils.init(this);
        //初始化崩溃收集
        CrashHander.install(this);

        //内存泄漏检测
        if (LOG_DEBUG) {
            if (LeakCanary.isInAnalyzerProcess(this)) {
                // This process is dedicated to LeakCanary for heap analysis.
                // You should not init your app in this process.
                return;
            }
            LeakCanary.install(this);
        }


        //日志开关
        L.initLoger(LOG_DEBUG);
        //初始化日志管理
        initLocalLog();
        //初始化数据库
        initDB();
        //初始化SP
        SPUtils.initSP("appData");
        FinalSPOperation.initSP("finalData");
        //初始化OKgo
        OkGo.init(this);
        OkGo.getInstance().addInterceptor(new LoggingInterceptor());
        //初始化路由
        initArouter();

        /**
         * 注册消息中心
         */
        MsgCentre.registMsgCentre();

        initLoadingLayout();

        /**
         * 打开PDA扫码功能
         */
        turnOnPDA();
        initVideoPlayer();
    }

    private void initVideoPlayer() {
        if (!BaseUtil.getCurProcessName(this).contains(":musicLibrary")) {
            try {
                MusicManager.get().setContext(this).init();
                MusicManager.get().setAutoPlayNext(false);
            } catch (Exception e) {
            }
        }
    }

    private void turnOnPDA() {
        sendBroadcast(new Intent("com.android.server.scannerservice.onoff")
                .putExtra("scanneronoff", 1));
    }

    private void initDB() {
        DaoManager.setupDatabase(this, AppData.LOG_DEBUG);
    }


    private void initLocalLog() {
        LocalLogManager.initLog(this);
    }


    private void initArouter() {
        if (LOG_DEBUG) {
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(this);
    }


    public static void exit() {
        ActivityStack.finishAll();
        //android.os.Process.killProcess(android.os.Process.myPid());
    }


    public static void initLoadingLayout() {
        LoadingLayout.getConfig()
                .setErrorText(ResourceUtils.getString(R.string.base_load_error))
                .setEmptyText(ResourceUtils.getString(R.string.base_no_data))
                .setNoNetworkText(ResourceUtils.getString(R.string.base_netError))
                .setErrorImage(R.mipmap.search_no_result)
                .setEmptyImage(R.mipmap.search_no_result)
                .setNoNetworkImage(R.mipmap.search_no_result)
                .setAllTipTextColor(R.color.base_slh_text_gray)
//                .setAllTipTextSize(ConvertUtils.px2sp(14))
                .setReloadButtonText(ResourceUtils.getString(R.string.click_retry))
//                .setReloadButtonTextSize(ConvertUtils.px2sp(14))
                .setReloadButtonTextColor(R.color.base_slh_text_normal)
                .setReloadButtonWidthAndHeight(ConvertUtils.px2dp(150), ConvertUtils.px2dp(40));
    }

}
