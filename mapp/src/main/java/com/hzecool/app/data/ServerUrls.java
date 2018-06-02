package com.hzecool.app.data;

import com.hzecool.app.bean.net.UrlBeanListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局url数据
 *
 * @author tutu
 * @date 2017/3/1
 */

public class ServerUrls {
    /**
     * 未登录情况的url集合
     */
    public static List<UrlBeanListBean.UrlBean> urlUnLoginInfos = new ArrayList<>();

    /**
     * 已登录获取的url集合
     */
    public static List<UrlBeanListBean.UrlBean> urlOnLoginInfos = new ArrayList<>();

    /**
     * 当前的使用的url
     */
    public static String BaseUrl;

    /**
     * 关于中使用的url
     */
    public static final String aboutUsUrl = "https://oa.hzdlsoft.com:7480/mycrm/";

    /**
     * 当前是用的第几条url
     */
    public static int currentPos = 0;

    /**
     * 用于请求url列表的专用url
     */
    public static final String ucUrl = "https://uc.hzdlsoft.com/mdm/";

    /**
     * 线上
     */
    public static final String ucSlhUrl = "http://assist.hzdlsoft.com:7086/assist/";

    /**
     * 上传文件
     */
    public static final String upFileUrl = "http://oa.hzdlsoft.com:7080/mycrm/uploadMultiFile.do";
    public static String upFileUrl2 = "uploadMultiFile.do";

    /**
     * 动态url的接口BdomainCode
     */
    public static String bDomainCode = "staffAssist";

    /**
     * 请求协议
     */
    public static String protocol = "https";

    /**
     * 日志上传地址
     */
    public static final String logUploadUrl = "http://log.hzdlsoft.com:8081/clog/clog";

    /**
     * 广告的url
     */
    public static final String adUrl = "http://ad.hzdlsoft.com/market/";

    /**
     * 意见反馈地址
     */
    public static final String SuggestionsUrl = "http://oatest.hzdlsoft.com:7080/mycrm/";

    /**
     * 发版说明
     */
    public static final String VersionExplainUrl = "http://oa.hzdlsoft.com:7080/mycrm/";

    /**
     * OA地址
     */
    public static final String OA_URL = "http://oa.hzdlsoft.com:7080/";

    /**
     * 物流地址
     */
    public static final String LOGISTIC = "https://m.kuaidi100.com/index_all.html?";
}
