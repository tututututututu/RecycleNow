package com.hzecool.core.activity.imagepager.dataprovider;

import com.hzecool.app.data.ParamConstant;
import com.hzecool.app.data.ServiceInterface;
import com.hzecool.app.data.UserData;
import com.hzecool.core.activity.imagepager.net.QRCodeInterface;
import com.hzecool.core.bean.NetQRbean;
import com.hzecool.core.net.Api;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * Created by song on 2017/8/30.
 */

public class DataProvider {
    /**
     * 获取小程序二维码
     */
    public static Observable<NetQRbean> querryQRCode(String styleId){
        Map<String,String> params = new HashMap<>();
        params.put(ParamConstant.INTERFACEID, ServiceInterface.INTERFACEID_CS_SHAREAPP);
        params.put("shopId", UserData.SLH_USER_INFO.getInvid());
        params.put("styleIds",styleId);

        return Api.getInstance(QRCodeInterface.class).querryQRCode(params);
    }
}
