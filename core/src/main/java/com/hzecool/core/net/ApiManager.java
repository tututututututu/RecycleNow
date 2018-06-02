package com.hzecool.core.net;

import android.text.TextUtils;

import com.hzecool.app.bean.net.UrlBeanListBean;
import com.hzecool.app.data.AppData;
import com.hzecool.app.data.ParamConstant;
import com.hzecool.app.data.ServerUrls;
import com.hzecool.common.json.GsonUtils;
import com.hzecool.common.utils.SPUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 提供retrofit apiService管理
 * 缓存使用过的ApiService实例
 * Created by tutu on 2017/3/15.
 */

public class ApiManager {
    private static Map<Class, Object> apiServiceMap = new HashMap<>();
    public static final int CONNECT_TIME_OUT_SECONDS = 10 * 1000;
    public static final int READ_TIME_OUT_SECONDS = 10 * 1000;
    public static final int WRITE_TIME_OUT_SECONDS = 10 * 1000;


    /**
     * 获取ApiService
     *
     * @param service ApiService类型
     * @param <T>     泛型类型
     * @return
     */
    public static <T> T getService(final Class service) {
//        T api = (T) apiServiceMap.get(service);
//        if (api == null) {
        Object o = creatService(service);
        apiServiceMap.put(service, o);
        return (T) o;
//        }
//        return (T) apiServiceMap.get(service);
    }

    /**
     * 获取ApiService 可以修改BaseUrl
     *
     * @param service ApiService类型
     * @param baseUrl 指定的BaseUrl
     * @param <T>
     * @return
     */
    public static <T> T getServiceWithBaseUrl(final Class<T> service, String baseUrl) {
//        T api = (T) apiServiceMap.get(service);
//        if (api == null) {
        Object o = creatServiceWithBaseUrl(service, baseUrl);
        apiServiceMap.put(service, o);
        return (T) o;
//        }
//        return (T) apiServiceMap.get(service);
    }


    /**
     * 创建ApiService实例
     *
     * @param service Service类型
     * @param <T>
     * @return
     */
    private static <T> T creatService(final Class<T> service) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(AppData.LOG_DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT_SECONDS, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIME_OUT_SECONDS, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIME_OUT_SECONDS, TimeUnit.MILLISECONDS)
//                .addInterceptor(logging)
                .retryOnConnectionFailure(true)
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new ParamsInterceptord())
                .build();

        String urlList = SPUtils.getString(ParamConstant.URL_LIST_LOGIN);
        String spUrl = "";
        if (!TextUtils.isEmpty(urlList)) {
            List<UrlBeanListBean.UrlBean> urlListSp = GsonUtils.jsonToArrayList(urlList, UrlBeanListBean.UrlBean.class);
            spUrl = urlListSp.get(0).getIpUrl();
        }

        return new Retrofit.Builder()
                .baseUrl(TextUtils.isEmpty(ServerUrls.BaseUrl) ? spUrl : ServerUrls.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
                .create(service);
    }


    /**
     * 创建ApiService实例
     *
     * @param service Service类型
     * @param baseUrl baseUrl
     * @param <T>
     * @return
     */
    private static <T> T creatServiceWithBaseUrl(final Class<T> service, String baseUrl) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(AppData.LOG_DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT_SECONDS, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIME_OUT_SECONDS, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIME_OUT_SECONDS, TimeUnit.MILLISECONDS)
//                .addInterceptor(logging)
                .retryOnConnectionFailure(true)
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new ParamsInterceptord())
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
                .create(service);
    }

}
