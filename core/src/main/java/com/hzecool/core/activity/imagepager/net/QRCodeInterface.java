package com.hzecool.core.activity.imagepager.net;

import com.hzecool.app.data.ServiceInterface;
import com.hzecool.core.bean.NetQRbean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by song on 2017/8/30.
 */

public interface QRCodeInterface {
    /**
     * 小程序二维码
     */
    @FormUrlEncoded
    @POST(ServiceInterface.REQUEST_PATH)
    Observable<NetQRbean> querryQRCode(
            @FieldMap Map<String,String> paramMap
    );
}
