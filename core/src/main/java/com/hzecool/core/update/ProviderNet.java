package com.hzecool.core.update;

import com.hzecool.app.data.AppData;
import com.hzecool.app.data.BusinessData;
import com.hzecool.app.data.ParamConstant;
import com.hzecool.common.utils.AppUtils;
import com.hzecool.core.bean.NetUpdateBean;
import com.hzecool.core.net.Api;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * 检查更新
 *
 * @author tutu
 * @date 2017/5/25
 */

public class ProviderNet {
    public static Observable<NetUpdateBean> requestCheckUpdate(String phone) {
        Map<String, String> params = new HashMap<>();
        params.put(ParamConstant.PRODUCT_VERSION, AppUtils.getAppVersionName());
        params.put("deviceno", phone);

        if (AppData.productType() == AppData.PRODUCT_TYPE_SHOP_ASSISTANT) {
            params.put("devicetype", BusinessData.PRODUCT_12);
            params.put(ParamConstant.DL_PRODUCT_CODE, ParamConstant.CLERK_ASSIST_ANDROID);
        } else if (AppData.productType() == AppData.PRODUCT_TYPE_WAREHOUSE_ASSISTANT) {
            params.put("devicetype", BusinessData.PRODUCT_13);
            params.put(ParamConstant.DL_PRODUCT_CODE, ParamConstant.STORE_ASSIST_PDA);
        }


        return Api.getInstance(ApiIterface.class).requestUpdate(params);
    }
}
