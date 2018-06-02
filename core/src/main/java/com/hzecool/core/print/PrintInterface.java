package com.hzecool.core.print;

import com.hzecool.app.data.ServiceInterface;
import com.hzecool.core.bean.ResponseStringBean;
import com.hzecool.core.print.cloud.CloudPrintBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by song on 2017/5/10.
 */

public interface PrintInterface {
    @FormUrlEncoded
    @POST(ServiceInterface.REQUEST_PATH)
    Observable<ResponseStringBean> requestXMLContent(
            @FieldMap Map<String,String> paramsMap
    );

    @FormUrlEncoded
    @POST(ServiceInterface.REQUEST_PATH)
    Observable<ResponseStringBean> updatePrintState(
            @FieldMap Map<String, String> paramsMap
    );

    /**
     * 云打印
     */
    @FormUrlEncoded
    @POST(ServiceInterface.REQUEST_PATH)
    Observable<CloudPrintBean> cloudPrint(
            @FieldMap Map<String, String> paramsMap
    );

}
