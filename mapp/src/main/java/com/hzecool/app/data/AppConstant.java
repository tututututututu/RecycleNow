package com.hzecool.app.data;

/**
 * 常量
 *
 * @author tutu
 * @date 2017/3/6
 */

public class


AppConstant {
    /**
     * 系统参数配置
     */
    public static final String SYS_CONFIG = "sys_config";

    /**
     * 用户信息
     */
    public static String USER_INFO = "userInfo";

    /**
     * 商陆花用户信息
     */
    public static String SLH_USER_INFO = "slhUserInfo";

    /**
     * 打印的类型
     * 打印类型：1:打印销售单,采购入库单;2:打印调拨出库单;3:打印销售订单
     */
    public static final int SALE_STORE_PRINT_TYPE = 1;
    public static final int TRANS_OUT_PRINT_TYPE = 2;
    public static final int SALE_ORDER_PRINT_TYPE = 3;


    public static final String DEVICE_ANDROID = "android";

    /**
     * 单据查询 -- 销售单
     */
    public static final int ORDER_TYPE_BILLING = 0;

    /**
     * 单据查询 -- 盘点单
     */
    public static final int ORDER_TYPE_INVENT = 1;

    /**
     * 本单类型
     */
    public static final String BILLING_TYPE = "billingType";

    /**
     * 历史--没有订单类型
     */
    public static final int ORDER_TYPE_NONE = -1;
    /**
     * 待调入
     */
    public static final int ORDER_TYPE_TO_TRANSFER_IN = 2;
    /**
     * 单据查询 -- 门店调入
     */
    public static final int ORDER_TYPE_TRANSFER_IN = 3;

    /**
     * 单据查询 -- 门店调出
     */
    public static final int ORDER_TYPE_TRANSFER_OUT = 4;
    /**
     * 单据查询 -- 訂貨單
     */
    public static final int ORDER_TYPE_BOOKING = 5;
    /**
     * 单据查询 -- 配货单
     */
    public static final int ORDER_TYPE_PICKING = 6;
    /**
     * 入库单
     */
    public static final int ORDER_TYPE_IN_STORAGE = 7;
    /**
     * 单据查询 -- 订货单转销售单
     */
    public static final int ORDER_TYPE_BOOK_TO_SALE = 8;

    /**
     * 销售单挂单
     */
    public static final int ORDER_TYPE_IN_SALE_PENDING = 8;

    /**
     * 订货单挂单
     */
    public static final int ORDER_TYPE_IN_BOOK_PENDING = 9;

    /**
     本单类型 --没有订单类型
     */
    public static final int BILLING_TYPE_NONE = -1;
    /**
     * 本单类型 --销售单
     */
    public static final int BILLING_TYPE_SELLING = 0;
    /**
     * 本单类型 --盘点
     */
    public static final int BILLING_TYPE_INVENT = 1;
    /**
     * 本单类型 --调出
     */
    public static final int BILLING_TYPE_BRING_OUT = 2;
    /**
     * 本单类型 --订货
     */
    public static final int BILLING_TYPE_BOOKING = 3;
    /**
     * 本单类型 -- 配货
     */
    public static final int BILLING_TYPE_PICKING = 4;
    /**
     * 本单类型 -- 入库单
     */
    public static final int BILLING_TYPE_STOCK_IN = 5;
    /**
     * 本单类型 -- 订货单转销售单
     */
    public static final int BILLING_TYPE_BOOKING_TO_SALE = 6;

    /**
     * 挂单类型  销售
     */
    public static final int PENDING_SALE = 30;

    /**
     * 挂单类型 订货单
     */
    public static final int PENDING_BOOKING = 31;
    /**
     * 门店调出状态，是否接收 - 未接收
     */
    public static final int RECIEVE_STATE_NO = 0;
    /**
     * 门店调出状态，是否接收 - 已接收
     */
    public static final int RECIEVE_STATE_YES = 2;

    /**
     * 款式上一次同步时间
     */
    public static final String SYNDATA_LAST_TIME_DRESS_STYLE = "synLastTime1";

    /**
     * 往来单位上一次同步时间
     */
    public static final String SYNDATA_LAST_TIME_DWXX = "synLastTime2";

    /**
     * 颜色上一次同步时间
     */
    public static final String SYNDATA_LAST_TIME_COLOR = "synLastTime3";

    /**
     * 尺寸上一次同步时间
     */
    public static final String SYNDATA_LAST_TIME_SIZE = "synLastTime4";


    /**
     * 品牌上一次同步时间
     */
    public static final String SYNDATA_LAST_TIME_BRAND = "synLastTime11";


    /**
     * 类别上一次同步时间
     */
    public static final String SYNDATA_LAST_TIME_CLASS = "synLastTime12";


    /**
     * 颜色组上一次同步时间
     */
    public static final String SYNDATA_LAST_TIME_COLOR_GROUP = "synLastTime13";

    /**
     * 尺码组上一次同步时间
     */
    public static final String SYNDATA_LAST_TIME_SIZE_GROUP = "synLastTime14";


    /**
     * 语音语义信息的上一次同步时间
     */
    public static final String SYNDATA_LAST_TIME_VOICE = "synLastTime45";

    /**
     * 款号详情的上一次同步时间
     */
    public static final String SYNDATA_LAST_TIME_DRESS_STYLE_DETAIL = "synLastTime6";

    /**
     * 店员的上一次同步时间
     */
    public static final String SYNDATA_LAST_TIME_STAFF = "synLastTime7";

    /**
     * 个推注册之后后端返回的两个字段   存起来 备用
     */
    public static String USER_EMB_GUID = "userEmbGuid";
    public static String DEVICE_EMD_GUID = "deviceEmbGuid";

    /**
     * 颜色尺码模式
     */
    public static String COLOR_SIZE_MODE = "0";
    /**
     * 均色均码模式
     */
    public static String NO_COLOR_SIZE_MODE = "1";

    /**
     * 发货状态-未发货
     */
    public static final String GOOD_STATE_NO_OUT = "0";

    /**
     * 发货状态-部分发货
     */
    public static final String GOOD_STATE_PART_OUT = "1";

    /**
     * 发货状态-全部发货
     */
    public static final String GOOD_STATE_ALL_OUT = "2";

    /**
     * 发货状态-结束
     */
    public static final String GOOD_STATE_END_OUT = "3";

    /**
     * 单据作废标记
     */
    public static final String INVALID_FLAG = "1";

    /**
     * 销售单为挂单的状态
     */
    public static final String PENDING_STATUS_FLAG = "9";

    /**
     * 系统参数 1 启用 0 不启用
     */
    public static final int SYS_CONFIG_USE = 1;
    public static final int SYS_CONFIG_UNUSE = 0;

    /**
     * 正常情况
     */
    public static final int NORMAL = 1;
    /**
     * 修改订单
     */
    public static final int MODIFY = 2;
    /**
     * 预览草稿
     */
    public static final int PREVIEW = 3;
    /**
     * 编辑草稿
     */
    public static final int LOAD = 4;
    /**
     * 复制订单
     */
    public static final int COPY = 5;

    /**
     * 无状态  为了发送一个事件先创建fragment接收后续事件
     */
    public static final int NONE = -1;

    /**
     * 语音语言类型设置---中文普通话
     */
    public static final int LANGUAGE_MAN = 0;

    /**
     * 语音语言类型设置---英文
     */
    public static final int LANGUAGE_EN = 1;

    /**
     * 语音语言类型设置---中文粤语
     */
    public static final int LANGUAGE_CAN = 2;


    /**
     * PDA扫码相关 常量
     */
    public static final String SCN_CUST_ACTION_SCODE = "com.android.server.scannerservice.broadcast";
    public static final String SCN_CUST_EX_SCODE = "scannerdata";
    public static final String SCN_CUST_ACTION_START = "android.intent.action.SCANNER_BUTTON_DOWN";
    public static final String SCN_CUST_ACTION_CANCEL = "android.intent.action.SCANNER_BUTTON_UP";
    private static final String SCANNER_CTRL_FILE = "/sys/devices/platform/scan_se955/se955_state";
    public static final String SCANNER_POWER = "com.android.server.scannerservice.onoff";


    public static final String NEW_LAND_BRODCAST = "nlscan.action.SCANNER_RESULT";
    public static final String NEW_LAND_SCAN_DATA1 = "SCAN_BARCODE1";
    public static final String NEW_LAND_SCAN_DATA2 = "SCAN_BARCODE2";


    public static String USER_MOBILE = "userMobile";
}
