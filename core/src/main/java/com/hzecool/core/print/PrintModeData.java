package com.hzecool.core.print;

import android.text.TextUtils;

import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.core.R;
import com.hzecool.core.sp.FinalSPOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 47066 on 2017/9/20.
 */

public class PrintModeData {
//0.本地打印 1.远程打印 2.本地+远程打印

    public static final String PRINT_MODE_NAME = "printModeName";
    public static final String PRINT_MODE = "printMode";

    public static List<PrintModeBean> getPrintModeBeanList() {
        List<PrintModeBean> printModeBeanList = new ArrayList<>();

        printModeBeanList.add(new PrintModeBean("0", ResourceUtils.getString(R.string.local_print)));
        printModeBeanList.add(new PrintModeBean("1", ResourceUtils.getString(R.string.remote_print)));
        printModeBeanList.add(new PrintModeBean("2", ResourceUtils.getString(R.string.local_remote_print)));

        return printModeBeanList;
    }


    public static class PrintModeBean {
        public String id;
        public String name;

        public PrintModeBean(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void update2LocalPrint(){
        savePrintMode("0",ResourceUtils.getString(R.string.local_print));
    }

    public static PrintModeBean getPrintMode() {
        String name = FinalSPOperation.getString(PRINT_MODE_NAME);
        String id = FinalSPOperation.getString(PRINT_MODE);

        if (TextUtils.isEmpty(id)) {
            id = "0";
            name = ResourceUtils.getString(R.string.local_print);
        }

        PrintModeBean printModeBean = new PrintModeBean(id, name);

        return printModeBean;
    }

    public static void savePrintMode(String id, String name) {
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(name)) {
            return;
        }

        FinalSPOperation.putString(PRINT_MODE, id);
        FinalSPOperation.putString(PRINT_MODE_NAME, name);
    }

    public static boolean needRemotePrint() {
        return getPrintMode().id.equals("0") ? false : true;
    }
}
