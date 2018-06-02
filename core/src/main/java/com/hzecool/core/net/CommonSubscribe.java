package com.hzecool.core.net;


import com.hzecool.common.utils.ExceptionUtils;
import com.hzecool.core.log.L;

import rx.Subscriber;


/**
 * 自定义订阅者
 *
 * @author tutu
 * @date 2017/3/10
 */

public abstract class CommonSubscribe<T> extends Subscriber<T> {
    protected abstract void onSuccess(T t);

    @Override
    public void onNext(T t) {
        try {
            onSuccess(t);
        } catch (Exception e) {
            L.logStackTraceToFile(e);
            e.printStackTrace();
        }
    }


    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        L.logFile("请求失败:" + e.getMessage() + "\n" + ExceptionUtils.getExceptionString(e));
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {
    }
}
