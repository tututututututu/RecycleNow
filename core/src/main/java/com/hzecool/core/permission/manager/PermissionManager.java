package com.hzecool.core.permission.manager;

import com.hzecool.app.data.AppConstant;
import com.hzecool.app.data.BusinessData;
import com.hzecool.app.data.UserData;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.R;

/**
 * @author 47066
 * @date 2017/10/30
 */

public class PermissionManager {

    public static final boolean notOpenPermissionControl = false;

    /**
     * 销售单查询
     *
     * @return
     */
    public static boolean saleBillingQuery() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26001");
    }

    /**
     * 销售单新增
     *
     * @return
     */
    public static boolean saleBillingAdd() {
        if (notOpenPermissionControl) {
            return true;
        }
        return saleBillingQuery()
                && UserData.USER_POWER_LIST.contains("26001-1");
    }

    /**
     * 销售单修改
     *
     * @return
     */
    public static boolean saleBillingModify() {
        if (notOpenPermissionControl) {
            return true;
        }
        return saleBillingQuery()
                && UserData.USER_POWER_LIST.contains("26001-2");
    }

    /**
     * 销售单作废
     *
     * @return
     */
    public static boolean saleBillingInvalid() {
        if (notOpenPermissionControl) {
            return true;
        }
        return saleBillingQuery()
                && UserData.USER_POWER_LIST.contains("26001-3");
    }

    /**
     * 盘点单查询
     *
     * @return
     */
    public static boolean cheackBillingQuery() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26002");
    }

    /**
     * 盘点单新增
     *
     * @return
     */
    public static boolean cheackBillingAdd() {
        if (notOpenPermissionControl) {
            return true;
        }
        return cheackBillingQuery()
                && UserData.USER_POWER_LIST.contains("26002-1");
    }

    /**
     * 盘点单修改
     *
     * @return
     */
    public static boolean cheackBillingModify() {
        if (notOpenPermissionControl) {
            return true;
        }
        return cheackBillingQuery()
                && UserData.USER_POWER_LIST.contains("26002-2");
    }

    /**
     * 盘点单作废
     *
     * @return
     */
    public static boolean cheackBillingInvalid() {
        if (notOpenPermissionControl) {
            return true;
        }
        return cheackBillingQuery()
                && UserData.USER_POWER_LIST.contains("26002-3");
    }

    /**
     * 销售单挂单查询
     */
    public static boolean salePengdingBillQuery() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("260012");
    }


    /**
     * 销售单挂单修改
     */
    public static boolean salePendingBillingModify() {
        if (notOpenPermissionControl) {
            return true;
        }
        return salePengdingBillQuery()
                && UserData.USER_POWER_LIST.contains("260012-1");
    }

    /**
     * 销售单挂单作废
     */
    public static boolean salePendingBillingInvalid() {
        if (notOpenPermissionControl) {
            return true;
        }
        return salePengdingBillQuery()
                && UserData.USER_POWER_LIST.contains("260012-2");
    }

    /**
     * 订货单挂单查询
     */
    public static boolean bookPengdingBillQuery() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("260012");
    }


    /**
     * 订货单挂单修改
     */
    public static boolean bookPendingBillingModify() {
        if (notOpenPermissionControl) {
            return true;
        }
        return bookPengdingBillQuery()
                && UserData.USER_POWER_LIST.contains("260012-1");
    }

    /**
     * 订货单挂单作废
     */
    public static boolean bookPendingBillingInvalid() {
        if (notOpenPermissionControl) {
            return true;
        }
        return bookPengdingBillQuery()
                && UserData.USER_POWER_LIST.contains("260012-2");
    }


    /**
     * 调出单新增
     *
     * @return
     */
    public static boolean bringOutBillingQuery() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26003");
    }

    /**
     * 调出单新增
     *
     * @return
     */
    public static boolean bringOutBillingAdd() {
        if (notOpenPermissionControl) {
            return true;
        }
        return bringOutBillingQuery()
                && UserData.USER_POWER_LIST.contains("26003-1");
    }

    /**
     * 调出单修改
     *
     * @return
     */
    public static boolean bringOutBillingModify() {
        if (notOpenPermissionControl) {
            return true;
        }
        return bringOutBillingQuery()
                && UserData.USER_POWER_LIST.contains("26003-2");
    }

    /**
     * 调出单作废
     *
     * @return
     */
    public static boolean bringOutBillingInvalid() {
        if (notOpenPermissionControl) {
            return true;
        }
        return bringOutBillingQuery()
                && UserData.USER_POWER_LIST.contains("26003-3");
    }

    /**
     * 调入单
     *
     * @return
     */
    public static boolean bringInBilling() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26004");
    }

    /**
     * 调入单作废
     *
     * @return
     */
    public static boolean bringInBillingInvalid() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26004-1");
    }

    /**
     * 待调入
     *
     * @return
     */
    public static boolean waiteBringInBilling() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26005");
    }

    /**
     * 订货单查询
     *
     * @return
     */
    public static boolean bookingBillingQuery() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26006");
    }

    /**
     * 订货单新增
     *
     * @return
     */
    public static boolean bookingBillingAdd() {
        if (notOpenPermissionControl) {
            return true;
        }
        return bookingBillingQuery()
                && UserData.USER_POWER_LIST.contains("26006-1");
    }

    /**
     * 入库单新增
     *
     * @return
     */
    public static boolean stockInBillingAdd() {
        return true;
    }

    /**
     * 入库单修改
     *
     * @return
     */
    public static boolean stockInBillingModify() {
        return true;
    }

    /**
     * 入库单作废
     *
     * @return
     */
    public static boolean stockInBillingInvalid() {
        return true;
    }

    /**
     * 订货单修改
     *
     * @return
     */
    public static boolean bookingBillingModify() {
        if (notOpenPermissionControl) {
            return true;
        }
        return bookingBillingQuery()
                && UserData.USER_POWER_LIST.contains("26006-2");
    }

    /**
     * 订货单作废
     *
     * @return
     */
    public static boolean bookingBillingInvalid() {
        if (notOpenPermissionControl) {
            return true;
        }
        return bookingBillingQuery()
                && UserData.USER_POWER_LIST.contains("26006-3");
    }

    /**
     * 配货单
     *
     * @return
     */
    public static boolean pickingBilling() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26007");
    }

    /**
     * 入库单
     */
    public static boolean inStorageBilling() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("260011");
    }

    /**
     * 扫码入库
     */
    public static boolean isScanInstorage() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("260010");
    }

    /**
     * 按訂貨開單
     */
    public static boolean bookingSale() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("260061");
    }

    /**
     * 统计业绩
     *
     * @return
     */
    public static boolean statisticsPerformance() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26008")
                && UserData.USER_POWER_LIST.contains("26008-1");
    }

    /**
     * 统计客户
     *
     * @return
     */
    public static boolean statisticsCustom() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26008")
                && UserData.USER_POWER_LIST.contains("26008-2");
    }

    /**
     * 统计爆款
     *
     * @return
     */
    public static boolean statisticsHotStyle() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26008")
                && UserData.USER_POWER_LIST.contains("26008-3");
    }


    /**
     * 我的货品
     *
     * @return
     */
    public static boolean myGoods() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26009")
                && UserData.USER_POWER_LIST.contains("26009-1");
    }

    /**
     * 货品分享
     *
     * @return
     */
    public static boolean goodsShare() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26009")
                && UserData.USER_POWER_LIST.contains("26009-2");
    }

    /**
     * 我的客户
     *
     * @return
     */
    public static boolean myCustom() {
        if (notOpenPermissionControl) {
            return true;
        }
        return UserData.USER_POWER_LIST.contains("26009")
                && UserData.USER_POWER_LIST.contains("26009-3");
    }


    /**
     * 是否开单新增 所有的单据权限都没有
     *
     * @return true 是  false 否
     */
    public static boolean isAddBillingEmpty() {
        if (!saleBillingAdd() && !cheackBillingAdd() && !bringOutBillingAdd() && !bookingBillingAdd()) {
            return true;
        }

        return false;
    }

    /**
     * 是否开单历史 所有的单据权限都没有
     *
     * @return true 是  false 否
     */
    public static boolean isHistoryEmpty() {
        if (!saleBillingQuery() && !cheackBillingQuery() && !bringOutBillingQuery() && !bookingBillingQuery() &&
                !bringInBilling() && !waiteBringInBilling() && !pickingBilling()) {
            return true;
        }

        return false;
    }

    /**
     * 是否修改订单 所有的单据权限都没有
     *
     * @return true 是  false 否
     */
    public static boolean isModifyBillingEmpty() {
        if (!saleBillingModify() && !cheackBillingModify() && !bringOutBillingModify() && !bookingBillingModify()) {
            return true;
        }

        return false;
    }

    /**
     * 是否统计 业绩,客户,爆款权限都没有
     *
     * @return true 是 false 否
     */
    public static boolean isStatisticsEmpty() {
        if (!statisticsPerformance() && !statisticsCustom() && !statisticsHotStyle()) {
            return true;
        }
        return false;
    }


    public static boolean checkOperatePermission() {
        if (PermissionManager.isAddBillingEmpty() && !BusinessData.isModifyBilling) {
            ToastUtils.showShortToast(R.string.no_billingtype_no_add_goods);
            return true;
        }

        if (PermissionManager.isModifyBillingEmpty() && BusinessData.isModifyBilling) {
            ToastUtils.showShortToast(R.string.no_billingtype_no_add_goods);
            return true;
        }

        return false;
    }

    /**
     * 获取默认的开单订单类型
     *
     * @return
     */
    public static int getDefaultBillingType() {
        if (cheackBillingAdd()) {
            return AppConstant.BILLING_TYPE_INVENT;
        } else if (bringOutBillingAdd()) {
            return AppConstant.BILLING_TYPE_BRING_OUT;
        } else if (stockInBillingAdd()) {
            return AppConstant.BILLING_TYPE_STOCK_IN;
        } else if (saleBillingAdd()) {
            return AppConstant.BILLING_TYPE_SELLING;
        } else if (bookingSale()) {
            return AppConstant.BILLING_TYPE_BOOKING_TO_SALE;
        }else {
            return AppConstant.BILLING_TYPE_NONE;
        }
    }

    /**
     * 获取默认的历史订单类型
     *
     * @return
     */
    public static int getDefaultHistoryType() {
        if (saleBillingQuery()) {
            return AppConstant.ORDER_TYPE_BILLING;
        } else if (cheackBillingQuery()) {
            return AppConstant.ORDER_TYPE_INVENT;
        } else if (bringOutBillingQuery()) {
            return AppConstant.ORDER_TYPE_TRANSFER_OUT;
        } else if (bringInBilling()) {
            return AppConstant.ORDER_TYPE_TRANSFER_IN;
        } else if (waiteBringInBilling()) {
            return AppConstant.ORDER_TYPE_TO_TRANSFER_IN;
        } else if (pickingBilling()) {
            return AppConstant.ORDER_TYPE_PICKING;
        } else if (inStorageBilling()) {
            return AppConstant.ORDER_TYPE_IN_STORAGE;
        } else if (bookingSale()) {
            return AppConstant.ORDER_TYPE_BOOK_TO_SALE;
        }else {
            return AppConstant.ORDER_TYPE_NONE;
        }
    }
}
