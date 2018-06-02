package com.hzecool.core.print;

import android.util.Log;

import com.hzecool.app.data.ParamConstant;
import com.hzecool.app.data.ServiceInterface;
import com.hzecool.common.json.GsonUtils;
import com.hzecool.core.bean.ResponseStringBean;
import com.hzecool.core.net.Api;
import com.hzecool.core.print.cloud.CloudPrintBean;
import com.hzecool.core.sp.FinalSPOperation;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;


/**
 * 打印获取打印xml数据
 * Created by song on 2017/5/10.
 */

public class ProviderNet {

    public static Observable<ResponseStringBean> requestXMLContent(String id, int printtype, boolean needRemotePrint,boolean isPendBill) {

        Map<String, String> params = new HashMap<>();
        params.put(ParamConstant.INTERFACEID, ServiceInterface.INTERFACEID_CS_PRINT);
        Map<String, String> jsonparam = new HashMap<>();
        jsonparam.put(ParamConstant.PK, id);
        jsonparam.put("printnum", FinalSPOperation.getString("printNum", "1"));
        jsonparam.put(ParamConstant.DEVICE, "android");
        jsonparam.put("printtype", String.valueOf(printtype));
        //http://jira.hzdlsoft.com:7082/browse/STAFFANR-35
        jsonparam.put("updatePrintFlag", "1");
        jsonparam.put("needRemotePrint", needRemotePrint ? "1" : "0");
        if (isPendBill){
            jsonparam.put("isPend", "1");
        }
        params.put(ParamConstant.JSON_pARAMS, GsonUtils.mapToJsonStr(jsonparam));

        Log.i("printParam", GsonUtils.mapToJsonStr(jsonparam).toString());
        return Api.getInstance(PrintInterface.class).requestXMLContent(params);
    }


    /**
     * 更新打印状态
     *
     * @param pk
     * @param printtype 单据类型：1:销售单,采购入库单;3:销售订单
     * @return
     */
    public static Observable<ResponseStringBean> updatePrintState(String pk, int printtype) {
        Map<String, String> params = new HashMap<>();
        params.put(ParamConstant.INTERFACEID, ServiceInterface.INTERFACEID_CS_UPDATE_PRINT);
        params.put(ParamConstant.PK, pk);
        params.put("printtype", String.valueOf(printtype));
        return Api.getInstance(PrintInterface.class).updatePrintState(params);
    }

    /**
     * 云打印
     */
    public static Observable<CloudPrintBean> cloudPrint(String interfaceid, String pk, String printToInv){
        Map<String,String> params = new HashMap<>();
        params.put(ParamConstant.INTERFACEID, interfaceid);
        params.put(ParamConstant.PK,pk);
        //params.put("printToInv",printToInv);
        return Api.getInstance(PrintInterface.class).cloudPrint(params);
    }
}
