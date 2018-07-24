package com.hzecool.app.data;

/**
 * app的全局数据
 *
 * @author tutu
 * @date 2017/3/9
 */

public class AppData {
    /**
     * 是否debug状态
     */
    public static final boolean LOG_DEBUG = false;

    /**
     * 是否展示奔溃界面
     */
    public static final boolean CRASH_SHOW = true;

    /**
     * 当前产品类型
     */
    public static int productType() {
        return AppData.PRODUCT_TYPE_SHOP_ASSISTANT;
    }

    //以上在发布时需要确认正确
    /**
     * 产品类型为店员助手
     */
    public static final int PRODUCT_TYPE_SHOP_ASSISTANT = 1;
    /**
     * 产品类型为仓配助手
     */
    public static final int PRODUCT_TYPE_WAREHOUSE_ASSISTANT = 2;

}
