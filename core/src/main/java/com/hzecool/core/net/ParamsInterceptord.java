package com.hzecool.core.net;


import android.text.TextUtils;

import com.hzecool.app.data.AppData;
import com.hzecool.app.data.ParamConstant;
import com.hzecool.app.data.ServiceInterface;
import com.hzecool.app.data.UserData;
import com.hzecool.common.utils.AppUtils;
import com.hzecool.common.utils.LanguageUtils;
import com.hzecool.common.utils.TimeUtils;
import com.hzecool.core.log.L;
import com.hzecool.core.sp.SPOperation;

import java.io.IOException;
import java.net.URLDecoder;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;


/**
 * retrofit参数拦截器  这里可以统一添加访问参数
 *
 * @author tutu
 * @date 2017/1/10
 */

public class ParamsInterceptord implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();
        HttpUrl.Builder builder = originalHttpUrl.newBuilder();

        if (!TextUtils.isEmpty(SPOperation.getSessionId())) {

            if (UserData.SLH_USER_INFO != null && "G2".equals(UserData.SLH_USER_INFO.getServerCode())
                    && isG2Request(original)) {
                builder.addQueryParameter(ParamConstant.SESSIONID1, SPOperation.getSessionId());
            } else {
                builder.addQueryParameter(ParamConstant.SESSIONID, SPOperation.getSessionId());
            }

        }


        if (AppData.productType() == AppData.PRODUCT_TYPE_SHOP_ASSISTANT) {
            builder.addQueryParameter(ParamConstant.DL_PRODUCT_CODE, ParamConstant.CLERK_ASSIST_ANDROID);
        } else if (AppData.productType() == AppData.PRODUCT_TYPE_WAREHOUSE_ASSISTANT) {
            builder.addQueryParameter(ParamConstant.DL_PRODUCT_CODE, ParamConstant.STORE_ASSIST_PDA);
        }


        builder.addQueryParameter("dlProductVersion", AppUtils.getAppVersionName());
        builder.addQueryParameter("dlUseFieldNameAlias", "1");
        builder.addQueryParameter("clientTime", String.valueOf(TimeUtils.getNowTimeMills()));
        builder.addQueryParameter("macCode", android.os.Build.BRAND + "  " + android.os.Build.VERSION.RELEASE);
        builder.addQueryParameter("language", LanguageUtils.getLanguageType());
        HttpUrl url = builder.build();
        Request.Builder requestBuilder = original.newBuilder()
                .url(url);
        Request request = requestBuilder.build();

        StringBuffer sb = new StringBuffer();
        sb.append("请求数据: " + request.url() + "&" + bodyToString(request))
                .append("\n\n");
        L.iTag("请求拦截器", sb.toString());
        return chain.proceed(request);
    }

    private static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
//            return buffer.readUtf8();
            return URLDecoder.decode(buffer.readUtf8(), "utf-8");
        } catch (final IOException e) {
            L.logFile(e.getMessage());
            e.printStackTrace();
            return "请求参数解析失败";
        }
    }

    private boolean isG2Request(Request original) {
        for (int i = 0; i < ((FormBody) original.body()).size(); i++) {

            for (String s : ServiceInterface.G2List()) {
                if (((FormBody) original.body()).encodedName(i).equals("apiKey")) {
                    if (((FormBody) original.body()).encodedValue(i).equals(s)) {
                        L.e("二代接口=======>>>"+((FormBody) original.body()).encodedValue(i));
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
