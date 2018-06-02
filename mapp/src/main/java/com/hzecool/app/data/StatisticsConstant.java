package com.hzecool.app.data;

/**
 * 统计用的常量
 *
 * @author tutu
 * @date 2017/6/1
 */
public class StatisticsConstant {
    /**
     * 表单保存 （label传单据类型）
     */
    public static String billing_save = "表单保存";
    /**
     * 表单修改 （label传单据类型）
     */
    public static String billing_modify = "表单修改";
    /**
     * 核销
     */
    public static String verification = "核销";
    /**
     * 支付账户选择  (label传支付方式)
     */
    public static String pay_account = "支付账户选择";
    /**
     * 清空单据
     */
    public static String clear_billing = "清空单据";
    /**
     * 保存草稿 (label传单据类型)
     */
    public static String save_draft = "保存草稿";
    /**
     * 预览草稿 (label传单据类型)
     */
    public static String preview_draft = "预览草稿";
    /**
     * 加载草稿 (label传单据类型)
     */
    public static String load_draft = "加载草稿";
    /**
     * 语音开单 (label传单据类型)
     */
    public static String voice_billing = "语音开单";
    /**
     * 添加特殊货品 （label传特殊货品名称）
     */
    public static String add_special_product = "添加特殊货品";
    /**
     * 新增客户
     */
    public static String add_customer = "新增客户";
    /**
     * 历史单据查询 （label传单据类型）
     */
    public static String order_history_query = "历史单据查询";
    /**
     * 业绩查询 (label传时间范围)
     */
    public static String performance = "业绩查询";
    /**
     * 客户查询 （label 传拿货最多等类型）
     */
    public static String customer_query = "客户查询";
    /**
     * 发短信 （label传类型）
     */
    public static String send_sms = "发短信";
    /**
     * 打电话 （label传类型）
     */
    public static String call_phone = "打电话";
    /**
     * 爆款查询 (label传类型)
     */
    public static String hot_style_query = "爆款查询";
    /**
     * 爆款分享 (label传类型)
     */
    public static String hot_style_share = "爆款分享";
    /**
     * 数据同步
     */
    public static String data_sync = "数据同步";
    /**
     * 清除缓存
     */
    public static String clear_cache = "清除缓存";

    /**
     * 退出当前账号
     */
    public static String logout = "退出当前账号";

    /**
     * 上传日志 （标签传上传日志或本地库）
     */
    public static String upload_log = "上传日志";
    /**
     * 排序栏_销售单
     */
    public static String history_order_sort_sale = "排序栏_销售单";
    /**
     * 排序栏_盘点单
     */
    public static String history_order_sort_check = "排序栏_盘点单";
    /**
     * 排序栏_调出单
     */
    public static String history_order_sort_waite_trasin = "排序栏_调出单";
    /**
     * 排序栏_调入单
     */
    public static String history_order_sort_trasin = "排序栏_调入单";
    /**
     * 排序栏_待调入
     */
    public static String history_order_sort_trasout = "排序栏_待调入";

    /**
     * 单据筛选_销售单
     */
    public static String history_order_query_condition_sale = "单据筛选_销售单";
    /**
     * 单据筛选_盘点单
     */
    public static String history_order_query_condition_check = "单据筛选_盘点单";
    /**
     * 单据筛选_待调入
     */
    public static String history_order_query_condition_waite_trasin = "单据筛选_待调入";
    /**
     * 单据筛选_调入单
     */
    public static String history_order_query_condition_trasin = "单据筛选_调入单";
    /**
     * 单据筛选_调出单
     */
    public static String history_order_query_condition_trasout = "单据筛选_调出单";

    public static String scan_add_product = "扫码开单";
    public static String product_share = "货品分享";
    public static String my_customer = "我的客户";
    public static String my_product = "我的货品";

    /**
     * 生成事件类型 具体的值  如:订单-->销售单
     *
     * @param value 具体事件类型的值
     * @return
     */
//    public static Map<String, String> genMap(String value) {
//        Map<String, String> map = new HashMap<>();
//        map.put("type", value);
//        return map;
//    }
}
