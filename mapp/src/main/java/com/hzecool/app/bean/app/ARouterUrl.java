package com.hzecool.app.bean.app;

/**
 * 跳转路径 集合
 * 跳转路径统一管理
 *
 * @author wangzhiguo
 * @date 2017/4/20
 */

public class ARouterUrl {

    /**
     * 销售单明细
     */
    public static final String AR_URL_SALEDETAIL = "/order/SaleDetailActivity";

    /**
     * 销售单明细(订货单)
     */
    public static final String AR_URL_BOOKING_SALEDETAIL = "/order/BookingDetailActivity";

    /**
     * 结算
     */
    public static final String AR_URL_BALANCE = "/blancecentre/BalanceActivity";

    public static final String AR_URL_BALANCE_PAY = "/blancecentre/BalancePayActivity";

    /**
     * 货品选择_均色均码
     */
    public static final String AR_URL_STOCK_SELECT_ALL_COLOR_SIZE = "/goods/AllColorSizeSingleSkuEditAcitivity";

    /**
     * 货品选择_颜色尺码
     */
    public static final String AR_URL_STOCK_SELECT_COLOR_SIZE = "/goods/ColorSizeSingleSkuEditAcitivity";

    /**
     * 货品选择_童装
     */
    public static final String AR_URL_STOCK_SELECT_CHILDREN = "/goods/ChildrenSingleSkuEditAcitivity";

    /**
     * 核销
     */
    public static final String AR_URL_VERIFY = "/blancecentre/VerifyActivity";

    /**
     * 客户选择
     */
    public static final String AR_URL_CUSTOM_CHOICE = "/custom/CustomerChoiceActivity";

    /**
     * 类别
     */
    public static final String AR_URL_BRAND_CHOICE = "/goods/BrandChoiceActivity";

    /**
     * 品牌
     */
    public static final String AR_URL_CLASS_CHOICE = "/goods/AR_URL_CLASS_CHOICE";

    /**
     * 尺码
     */
    public static final String AR_URL_SIZE_CHOICE = "/goods/AR_URL_SIZE_CHOICE";

    /**
     * 颜色
     */
    public static final String AR_URL_COLOR_CHOICE = "/goods/AR_URL_COLOR_CHOICE";

    /**
     * 特殊货品选择
     */
    public static final String AR_URL_SPACIAL_PRODUCT = "/goods/SpecialProductActivity";

    /**
     * 开单结束
     */
    public static final String AR_URL_BILL_FINISH = "/blancecentre/FinishActivity";

    /**
     * 店员助手登录
     */
    public static final String AR_URL_LOGIN = "/login/LoginActivity";

    /**
     * 仓配助手登录
     */
    public static final String AR_URL_WARE_HOUSE_LOGIN = "/warehouseassistant/LoginActivity";

    /**
     * 调出成功
     */
    public static final String AR_URL_BRING_OUT_SECCESS = "/blancecentre/BringOutBillingSuccessActivity";

    /**
     * 盘点成功
     */
    public static final String AR_URL_CHECK_SECCESS = "/blancecentre/CheckBillingSuccessActivity";

    /**
     * 新增客户
     */
    public static final String AR_URL_ADD_CUSTOM = "/custom/AddCustomerActivity";

    /**
     * 销售单，盘点单，调出
     */
    public static final String AR_URL_BILL_MODIFY = "/billing/BillingModifyAcitvity";

    /**
     * 颜色尺码模式添加货品的fragment
     */
    public static final String AR_URL_BILL_GOODS_SIZE_COLOR_FRAGMENT = "/goods/AddProductSizeColorFragment";

    /**
     * 货品搜索activity
     */
    public static final String AR_URL_GOODS_SEARCH = "/goods/SearchActivity";

    /**
     * 标签设置
     */
    public static final String AR_URL_MARK_SET = "/mine/MarkSettingActivity";

    /**
     * 标签编辑
     */
    public static final String AR_URL_MARK_EDIT = "/mine/EditMarkActivity";

    /**
     * 盘点，调入，调出明细
     */
    public static final String AR_URL_ORDER_DETAIL = "/order/OrderDetailActivity";

    public static final String AR_URL_TRANS_OUT_DETAIL = "/order/TransOutDetailActivity";
    public static final String AR_URL_INVENTORY_DETAIL = "/order/InventoryDetailActivity";
    public static final String AR_URL_TRANS_IN_DETAIL = "/order/TransInDetailActivity";
    public static final String AR_URL_TRANS_AWAIT_DETAIL = "/order/TransAwaitDetailActivity";

    /**
     * 日志管理
     */
    public static final String AR_URL_LOG_MANAGE = "/mmine/LogManageActivity";

    /**
     * 草稿箱
     */
    public static final String AR_URL_DRAFT_LIST = "/billing/DraftListActivity";

    /**
     * 草稿箱预览
     */
    public static final String AR_URL_DRAFT_PREVIEW = "/billing/DraftPreviewActivity";

    /**
     * 调入成功
     */
    public static final String AR_URL_TRANS_IN_SUCCESS = "/order/TransSuccessActivity";

    /**
     * 引导页
     */
    public static final String AR_URL_GUIDE = "/app/GuideActivity";

    /**
     * 时间限制使用错误界面
     */
    public static final String AR_URL_USELESS_TIME = "/app/UselessTimeActivity";

    /**
     * 语音开单界面
     */
    public static final String AR_URL_VOICE = "/voice_qrcode/VoiceActivity";

    /**
     * 帮助文档
     */
    public static final String AR_URL_HELPDOCUMENT = "/mmine/HelpDocumentActivity";

    /**
     * 发版说明
     */
    public static final String AR_URL_VERSION = "/mmine/VersionExplainActivity";

    /**
     * 主页
     */
    public static final String AR_URL_MAIN = "/app/MainActivity";

    /**
     * 款式详情
     */
    public static final String AR_URL_DRESS_DETAIL = "/mdressstyle/DressStyleDetailActivity";

    /**
     * 查看大图
     */
    public static final String AR_URL_VIEW_IMG = "/common/ImagePagerActivity";

    /**
     * jsbridge webview
     */
    public static final String AR_URL_WEB_VIEW = "/core/JsBridgeWebViewActivity";
    public static final String AR_URL_WEB_VIEW_LANDSCAPE = "/core/JsBridgeWebViewActivityLandScape";

    public static final String AR_URL_CUSTOMER_DETAIL = "/mine/CustomerDetailActivity";

    public static final String AR_URL_QRCODE_BILL = "/voice_qrcode/QrCodeBillActivity";
    public static final String AR_URL_SCAN = "/voice_qrcode/CommonScanActivity";


    public static final String AR_URL_LOGISTICS = "/balancecentre/CollectActivity";
    public static final String AR_URL_PICKING_DETAIL = "/order/PickingDetailContainerActivity";

    public static final String AR_URL_QR_ZXING = "/voice_qrcode/QrZxingActivity";
    public static final String AR_URL_MANUFAVTURER = "/order/ManufacturerActivity";

    public static final String AR_URL_INSTORAGE_DDETAIL = "/order/InstorageDetailActivity";
    public static final String AR_URL_MANUFAVTURER_ERROR = "/order/ManufacturerErrorActivity";
    /**
     * 入库单成功
     */
    public static final String AR_URL_STOCK_IN_FINISH = "/finish/StockInFinishActivity";
}
