package com.hzecool.core.net;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hzecool.app.bean.app.ARouterUrl;

/**
 * 业务异常定义 处理
 * Created by tutu on 2017/1/10.
 */

public class BussinessException extends Exception {
    private String code;

    public BussinessException() {
        this(null, null);
    }

    public BussinessException(String code, String msg) {
        super(msg);
        this.code = code;
        switch (code) {
            case "404":
                break;
            //登录失效
            case "-9":
                ARouter.getInstance().build(ARouterUrl.AR_URL_LOGIN).navigation();
                break;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
