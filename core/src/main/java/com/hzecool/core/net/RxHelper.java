package com.hzecool.core.net;


import android.text.TextUtils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hzecool.app.bean.app.ARouterUrl;
import com.hzecool.app.bean.dict.BaseNetResponseBean;
import com.hzecool.core.bean.BaseResponseBean;
import com.hzecool.core.log.L;
import com.hzecool.core.manager.ActivityStack;

import java.lang.reflect.Field;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * retrofit返回调度中心
 * 线程调度  统一结果code处理
 * Created by tutu on 2017/3/10.
 */

public class RxHelper {

    public static <T> Observable.Transformer<BaseResponseBean<T>, T> RxHandleResult() {
        return baseResponseObservable -> baseResponseObservable.flatMap(tBaseResponse -> {
            /**
             * code是适配后台助手新框架  0为成功 非0失败
             */
            if ("0".equals(tBaseResponse.getCode())) {
                return createData(tBaseResponse.getData());
            } else {
                return Observable.error(new BussinessException(tBaseResponse.getCode(), tBaseResponse
                        .getMsg()));
            }
        }).compose(switchSchedulers());
    }

    public static <T> Observable.Transformer<T, T> RxSlhHandleResult() {
        return baseResponseObservable -> baseResponseObservable.flatMap(tBaseResponse -> {
            /**
             * error  没有这个字段为正常  否则失败
             */
            String error = "";
            //FIXME 默认所有实体继承自BaseNetResponseBean ，未继承的继续使用原有方法
            if (tBaseResponse instanceof BaseNetResponseBean) {
                error = ((BaseNetResponseBean) tBaseResponse).getError();
                if ("-11".equals(((BaseNetResponseBean) tBaseResponse).getErrorCode())) {
                    ActivityStack.finishAll();
                    ARouter.getInstance().build(ARouterUrl.AR_URL_USELESS_TIME)
                            .withString("dis", ((BaseNetResponseBean) tBaseResponse).getError())
                            .navigation();
                    return null;
                }
            } else {
                try {
                    Field f = tBaseResponse.getClass().getDeclaredField("error");
                    f.setAccessible(true);
                    error = (String) f.get(tBaseResponse);
                } catch (Exception e) {

                }
            }
            if (TextUtils.isEmpty(error)) {
                return createData(tBaseResponse);
            } else {
                L.logFile(error);
                return Observable.error(new BussinessException("-1", error));
            }
        }).compose(switchSchedulers());
    }

    private static <T> Observable<T> createData(T data) {
        return Observable.create(subscriber -> {
            try {
                L.ir(data.toString());
                subscriber.onNext(data);
                subscriber.onCompleted();
            } catch (Exception e) {
                L.logFile(e.getMessage());
                subscriber.onError(e);
            }
        });
    }

    public static <T> Observable.Transformer<T, T> switchSchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
