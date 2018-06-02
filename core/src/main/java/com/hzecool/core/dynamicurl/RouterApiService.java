package com.hzecool.core.dynamicurl;


import com.hzecool.app.bean.net.UrlBeanListBean;
import com.hzecool.core.bean.BaseResponseBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 路由Service
 * Created by tutu on 2017/3/3.
 */

public interface RouterApiService {
    /**
     * 获取最新服务器url列表
     */
    @FormUrlEncoded
    @POST("api.do")
    Observable<BaseResponseBean<UrlBeanListBean>> requestUrlList(
            @FieldMap Map<String, String> paramsMap
    );
}
