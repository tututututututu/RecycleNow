package com.hzecool.core.update;

import com.hzecool.core.bean.NetUpdateBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 获取服务器最新版本信息，访问网络接口
 * Created by tutu on 2017/3/16.
 */
public interface ApiIterface {
    /**
     * 升级检测
     */
    @FormUrlEncoded
    @POST("checkUpgrade.do")
    Observable<NetUpdateBean> requestUpdate(
            @FieldMap Map<String, String> paramsMap
    );
}
