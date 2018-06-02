package com.hzecool.app.data;

/**
 * 网络请求参数常量
 * Created by wangzhiguo on 2017/5/6
 *
 * @author yksoft
 */
public class ParamConstant {

    /**
     * 请求的固定字段code
     * 客户区域：areacode
     * 厂商区域: suppareacode
     */
    public static final String CODE = "code";
    public static final String CODES = "codes";

    /**
     * 客户区域：areacode
     */
    public static final String AREA_CODE = "areacode";

    /**
     * 允许欠款：code
     */
    public static final String ALLOW_REBACK_CODE = "48";

    public static final String STYLE_IDS = "styleids";
    public static final String SHOP_iD = "shopid";
    public static final String DWID = "dwid";
    public static final String BILLING_TYPE = "billingType";
    public static final String PENDING_TYPE = "pendingType";

    /**
     * 页码大小
     */
    public static final String PAGE_SIZE = "pagesize";
    /**
     * 门店ID
     */
    public static final String SHOP_ID = "shopId";
    /**
     * ID
     */
    public static final String ID = "id";
    /**
     * HashKey
     */
    public static final String HASHKEY = "hashkey";

    /**
     * 用户手机号
     */
    public static String USER_PHONE = "user_phone";

    public static String PHONE = "phone";

    /**
     * 登录情况下路由请求的url列表
     */
    public static String URL_LIST_LOGIN = "url_list_login";

    /**
     * 没有登录情况下路由请求的url列表
     */
    public static String URL_LIST_UNLOGIN = "url_list_unlogin";

    /**
     * UUID
     */
    public static String UUID = "uuid";

    /**
     * 请求的固定字段apiKey
     */
    public static String APIKEY = "apiKey";

    /**
     * 请求的固定字段interfaceid
     */
    public static String INTERFACEID = "interfaceid";


    /**
     * 请求的固定字段jsonParam
     */
    public static String JSON_PARAMS = "jsonParam";

    /**
     * 请求的固定字段jsonParam
     */
    public static String JSON_pARAMS = "jsonparam";

    /**
     * 请求的固定字段productType
     */
    public static String PRODUCT_TYLE = "productType";
    /**
     * 请求的固定字段productType
     */
    public static String PRODUCT_tYLE = "producttype";

    public static String PRODUCT_VERSION = "productVersion";

    public static String MAC = "mac";

    public static String STORE_ASSIST_PDA = "storeAssistPDA";
    public static String CLERK_ASSIST_ANDROID = "clerkAssistAndroid";
    public static String DEVICE = "device";
    /**
     * 服务器端 单词拼写错误 只能将错就错
     */
    public static String OS_VERSION = "osVerison";
    public static String DL_PRODUCT_CODE = "dlProductCode";


    /**
     * 请求的固定字段sign
     */
    public static String SIGN = "sign";


    /**
     * SESSIONID
     */
    public static String SESSIONID = "sessionid";
    public static String SESSIONID1 = "sessionId";

    /**
     * 开单请求必传字段  actid = 21
     */
    public static String ACTID = "21";

    /**
     * 请求固定参数 PK
     */
    public static String PK = "pk";

    /**
     * 请求固定参数 action
     */
    public static String ACTION = "action";

    /**
     * 是否是挂单
     */
    public static String IS_PEND = "isPend";

    /**
     * 下单保存传递数据
     */
    public static String NET_BALANCE_REQUEST_BEAN = "netBalanceRequestBean";

    /**
     * 盘点单 盘点状态： 0 未盘 1 已盘
     */
    public static final String INVENTORY_NO = "0";
    public static final String INVENTORY_YES = "1";

    /**
     * 调出单接收状态： 0 未盘 1 已盘
     */
    public static final String RECEIVED_NO = "0";
    public static final String RECEIVED_YES = "2";

    /**
     * 核销/配货状态 0:未,1:是
     */
    public static final String PICK_OR_VERI_NO = "0";
    public static final String PICK_OR_VERI__YES = "1";

    /**
     * 银行字典查询参数
     */
    public static final String DICT_SOURCE_BANK = "finaccountcode_sale_card";
    /**
     * 物流商字典查询参数
     */
    public static final String DICT_SOURCE_LOGIS = "logiscode";

    /**
     * 发货状态字典查询参数
     */
    public static final String DICT_SOURCE_DELIVER = "25";

    /**
     * 是否颜色尺码
     */
    public static final String IGNORE_COLOR_SIZE = "ignorecolorsize";

    /**
     * 默认信用额度
     */
    public static final String DEFAULT_CREDIT = "sales_default_creditmoney";

    /**
     * 特殊货品标记值
     * flag = 2 表示该货品为特殊货品
     */
    public static final String SPECIAL_GOOD_TYPE_ID = "9";

    /**
     * 特殊货品标记值
     * flag = 2 表示该货品为特殊货品
     */
    public static final String SPECIAL_GOOD_FLAG = "2";

    /**
     * 返回结果
     */
    public static final String RESPONSE_STATE_OK = "ok";

    /**
     * 新增客户默认pk值
     */
    public static String ADD_CUSTOMER_DEFAULT_PK = "0";

    /**
     * 草稿传递的参数名
     */
    public static String DRAFT_PARAMS = "draftContentJson";


    /**---------------------------------界面跳转参数的名称常量------------------------------------*/

    /**
     * 跳转到添加货品
     */
    public static final String LDRESSSKU = "lDressSkuBean";
    public static final String IS_SALE_RETURN = "isSaleReturn";
    public static final String COME_FROM = "comFrom";
    //动画需要的
    public static final String SHARE_ELEMENT = "product";

    /**
     * 跳转到颜色尺码的货品选择
     */
    public static final String SPU = "spu";

    /**
     * 是否是修改订单
     */
    public static final String IS_MODIFY_BILLING = "isModifyBilling";
    /**
     * 是否是预览
     */
    public static final String IS_PREVIEW = "preview";
    /**
     * 客户
     */
    public static final String CUSTOM = "custom";
    /**
     * 门店
     */
    public static final String SHOP = "shop";
    /**
     * 是否是新增
     */
    public static final String IS_ADD = "isAdd";

    /**
     * 拿货最多
     */
    public static final int MAX_PRODUCT = 0;
    /**
     * 欠款最多
     */
    public static final int MAX_DEBT = 1;
    /**
     * 拿货最少
     */
    public static final int MIN_PRODUCT = 2;
    /**
     * 到店最少
     */
    public static final int MIN_ARRIVE = 3;

    public static final String IS_AUTO_PRINT = "isOpen";
}
