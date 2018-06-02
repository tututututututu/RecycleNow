package com.hzecool.core.print.cloud;

import com.hzecool.core.net.RxHelper;
import com.hzecool.core.net.RxSubscribe;
import com.hzecool.core.print.IPrint;
import com.hzecool.core.print.PrintService;
import com.hzecool.core.print.ProviderNet;

/**
 * @author tutu
 * @time 2018/4/3
 */

public class CloudPrintService implements IPrint {
    @Override
    public void print(String id, int printtype, PrintService.PrintResutlCallBack printResutlCallBack,boolean isPending) {

        String interfaceId;
        /**
         * 1:打印销售单,采购入库单;2:打印调拨出库单;3:打印销售订单
         */
        switch (printtype) {
            case 1:
                interfaceId = "cs-printSaleTrade";
                break;
            case 2:
                interfaceId = "cs-printMoveTrade";
                break;
            case 3:
                interfaceId = "cs-printSaleOrderTrade";
                break;
            default:
                return;
        }

        ProviderNet.cloudPrint(interfaceId, id, "0")
                .compose(RxHelper.RxSlhHandleResult())
                .subscribe(new RxSubscribe<CloudPrintBean>() {
                    @Override
                    protected void onSuccess(CloudPrintBean cloudPrintBean) {
                        printResutlCallBack.onSuccess();
                    }

                    @Override
                    protected void onFail(String msg) {
                        printResutlCallBack.onFailed(msg);
                    }

                    @Override
                    protected void onNetError(String msg) {
                        printResutlCallBack.onFailed(msg);
                    }
                });
    }
}
