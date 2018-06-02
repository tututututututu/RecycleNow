package com.hzecool.core.print;

/**
 * Created by wangzhiguo on 2017/8/3
 */
public interface IPrint {
    void print(String id, int printtype, PrintService.PrintResutlCallBack printResutlCallBack,boolean isPending);
}
