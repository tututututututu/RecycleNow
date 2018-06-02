package com.hzecool.core.base;


import com.hzecool.core.log.L;

import rx.internal.util.SubscriptionList;

/**
 *
 * @author tutu
 * @date 2016/12/31
 */

public abstract class TBasePresenter<V extends TIBaseView> {
    /**
     * 当内存不足释放内存
     */
    public V mViewRef;
    public SubscriptionList mSubscriptionList;

    /**
     * bind p with v
     *
     * @param view
     */
    public void attachView(V view) {
        mViewRef = view;
        mSubscriptionList = new SubscriptionList();
    }

    public void detachView() {
        mSubscriptionList.unsubscribe();
        if (mViewRef != null) {
            mViewRef = null;
            L.logFile("view被回收了 " + getClass().getSimpleName());
        }
    }

    /**
     * 获取view的方法
     *
     * @return 当前关联的view
     */
    public V getView() {
        return mViewRef;
    }

    protected abstract void start();
}
