package com.hzecool.core.print;

/**
 * Created by wangzhiguo on 2017/8/3
 */
public class PrintProxy implements IPrint {

    private IPrint mIPrint;

    public PrintProxy(IPrint iPrint){
        mIPrint = iPrint;
    }

    @Override
    public void print(String id, int printtype, PrintService.PrintResutlCallBack printResutlCallBack,boolean isPending) {
        mIPrint.print(id, printtype, printResutlCallBack,isPending);
    }
}
