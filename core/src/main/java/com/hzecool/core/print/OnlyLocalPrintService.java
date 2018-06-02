package com.hzecool.core.print;

import android.text.TextUtils;
import android.util.Log;

import com.hzecool.common.utils.HandlerUtil;
import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.R;
import com.hzecool.core.bean.ResponseStringBean;
import com.hzecool.core.log.L;
import com.hzecool.core.net.RxHelper;
import com.hzecool.core.net.RxSubscribe;
import com.hzecool.core.socket.TcpClient;
import com.hzecool.core.sp.FinalSPOperation;

/**
 * 打印
 * Created by song on 2017/5/10.
 */

public class OnlyLocalPrintService implements IPrint {

    private void ShowDialog(String content) {
        HandlerUtil.post(() -> ToastUtils.showLongToast(content));
    }

    @Override
    public void print(String id, int printtype, PrintService.PrintResutlCallBack printResutlCallBack,boolean isPending) {
        L.logFile("PrintService  调用打印 print() 方法" + " id=" + id + " printtype=" + printtype);
        try {
            if (!checkIpPort()) {
                printResutlCallBack.onFailed(ResourceUtils.getString(R.string.print_port_ip_error));
                return;
            }

            ProviderNet.requestXMLContent(id, printtype, false,isPending)
                    .compose(RxHelper.RxSlhHandleResult())
                    .subscribe(new RxSubscribe<ResponseStringBean>() {
                        @Override
                        protected void onSuccess(ResponseStringBean responseStringBean) {
                            Log.i("requestXMLContent", "onSuccess - > printReal()");
                            L.logFile("PrintService  onSuccess()---> 打印数据:" + responseStringBean.toString());
                            printReal(responseStringBean.getContent(), printResutlCallBack);
                        }

                        @Override
                        protected void onFail(String msg) {
                            if (printResutlCallBack != null) {
                                printResutlCallBack.onFailed(msg);
                            }
                        }

                        @Override
                        protected void onNetError(String msg) {
                            printResutlCallBack.onFailed(msg);
                        }
                    });

        } catch (Exception e) {
            if (printResutlCallBack != null) {
                printResutlCallBack.onFailed(ResourceUtils.getString(R.string.print_port_ip_error));
            }
            return;
        }
    }

    private boolean checkIpPort() {
        String printPoint = FinalSPOperation.getString("printPort", "22222");
        int mPort = Integer.parseInt(printPoint);
        String mAddress = FinalSPOperation.getString("printAddress", "");
        if (mPort == 0 || TextUtils.isEmpty(mAddress)) {
            ShowDialog(ResourceUtils.getString(R.string.print_port_ip_error));
            return false;
        }
        return true;
    }

    private void printReal(String msg, PrintService.PrintResutlCallBack printResutlCallBack) {
        new Thread() {
            @Override
            public void run() {
                try {
                    L.logFile("PrintService  printReal()---> 打印数据:" + msg);
                    int mPort = Integer.parseInt(FinalSPOperation.getString("printPort", "22222"));
                    String mAddress = FinalSPOperation.getString("printAddress", "");
                    if (mPort == 0 || TextUtils.isEmpty(mAddress)) {
                        ShowDialog(ResourceUtils.getString(R.string.print_port_ip_error));
                        if (printResutlCallBack != null) {
                            printResutlCallBack.onFailed(ResourceUtils.getString(R.string.print_port_ip_error));
                        }
                        return;
                    }

                    if (TextUtils.isEmpty(msg)) {
                        ShowDialog(ResourceUtils.getString(R.string.empty_print_data));
                        return;
                    }

                    new TcpClient().go(mAddress, mPort, msg, new TcpClient.CallBack() {
                        @Override
                        public void onConnectError(String msg) {
                            ToastUtils.showShortToastSafe(ResourceUtils.getString(R.string.link_print_faild));
                            printResutlCallBack.onFailed(ResourceUtils.getString(R.string.link_print_faild));
                        }

                        @Override
                        public void onWriteError(String msg) {
                            ToastUtils.showShortToastSafe(ResourceUtils.getString(R.string.print_data_faild));
                            printResutlCallBack.onFailed(ResourceUtils.getString(R.string.print_data_faild));
                        }

                        @Override
                        public void onSuccess() {
                            printResutlCallBack.onSuccess();
                        }
                    });
                } catch (Exception e) {
                    ToastUtils.showShortToastSafe(ResourceUtils.getString(R.string.check_print_setting));
                    printResutlCallBack.onFailed(ResourceUtils.getString(R.string.check_print_setting));
                }
            }
        }.start();
    }
}
