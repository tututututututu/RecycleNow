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

import static com.hzecool.app.data.AppConstant.SALE_STORE_PRINT_TYPE;

/**
 * 打印
 *
 * @author song
 * @date 2017/5/10
 */

public class PrintService implements IPrint {

    private void ShowDialog(String content) {
        HandlerUtil.post(() -> ToastUtils.showLongToast(content));
    }

    @Override
    public void print(String id, int printtype, PrintResutlCallBack printResutlCallBack, boolean isPending) {
        L.logFile("PrintService  调用打印 print() 方法" + " id=" + id + " printtype=" + printtype);
        L.logStackTraceToFile(new Throwable());
        PrintModeData.PrintModeBean printModeBean = PrintModeData.getPrintMode();

        /**
         * 如果是销售单才有远程打印
         */
        if (SALE_STORE_PRINT_TYPE != printtype) {
            printModeBean.id = "0";
        }

        try {
            if ("1".equals(printModeBean.id)) {
                /**
                 * 仅远程打印  不检查ip 端口
                 */
            } else if ("2".equals(printModeBean.id)) {
                /**
                 * 远程+本地  检查端口不阻止打印继续
                 */
                checkIpPort();
            } else {
                if (!checkIpPort()) {
                    printResutlCallBack.onFailed(ResourceUtils.getString(R.string.print_port_ip_error));
                    return;
                }
            }

            ProviderNet.requestXMLContent(id, printtype, PrintModeData.needRemotePrint(), isPending)
                    .compose(RxHelper.RxSlhHandleResult())
                    .subscribe(new RxSubscribe<ResponseStringBean>() {
                        @Override
                        protected void onSuccess(ResponseStringBean responseStringBean) {
                            Log.i("requestXMLContent", "onSuccess - > printReal()");
                            L.logFile("PrintService  onSuccess()---> 打印数据:" + responseStringBean.toString());
                            if ("0".equals(printModeBean.id)) {
                                /**
                                 * 本地打印
                                 */
                                if (TextUtils.isEmpty(responseStringBean.getContent())) {
                                    printResutlCallBack.onFailed(ResourceUtils.getString(R.string.empty_print_data));
                                } else {
                                    printReal(responseStringBean.getContent(), printResutlCallBack);
                                }
                            } else if ("1".equals(printModeBean.id)) {
                                /**
                                 * 远程打印
                                 */
                                printResutlCallBack.onSuccess();
                            } else {
                                /**
                                 * 远程+本地打印
                                 */
                                printReal(responseStringBean.getContent(), printResutlCallBack);
                                printResutlCallBack.onSuccess();
                            }
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

    private void printReal(String msg, PrintResutlCallBack printResutlCallBack) {
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

    public interface PrintResutlCallBack {
        void onSuccess();

        void onFailed(String msg);
    }
}
