package com.hzecool.app.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tutu
 * @time 2018/1/26
 */

public class BusinessData {
    /**
     * 刷卡银行名称列表
     */
    public static Map<String, String> accCardNameMap = new HashMap<>();
    /**
     * 汇款银行名称列表
     */
    public static Map<String, String> accRmitNameMap = new HashMap<>();
    /**
     * 物流商名称列表
     */
    public static Map<String, String> logisNameMap = new HashMap<>();
    /**
     * 当前本单界面是哪个fragment
     * 0:开单
     * 1:盘点
     * 2:调出
     */
    public static int BILLING_TYPE = AppConstant.BILLING_TYPE_NONE;
    /**
     * 是否是修改订单进来的fragment
     * 用来控制修改订单发送的一些事件
     * 比如添加货品 修改客户等不被本单的fragment所接收(事件隔离)
     */
    public static boolean isModifyBilling = false;

    public static boolean isDealSaleReturnEvent = true;

    /**
     * 获取物流商名称
     *
     * @param lid
     * @return
     */
    public static String getLogisName(String lid) {
        return logisNameMap.get(lid);
    }

    /**
     * 产品类型 --- 店员助手
     */
    public static final String PRODUCT_12 = "12";
    /**
     * 产品类型 --- 仓配助手
     */
    public static final String PRODUCT_13 = "13";

}
