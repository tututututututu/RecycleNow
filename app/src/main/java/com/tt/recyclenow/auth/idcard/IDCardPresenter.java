package com.tt.recyclenow.auth.idcard;

import com.alibaba.fastjson.JSON;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.Constants;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.BaseRep;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author tutu
 * @time 2018/6/9
 */

public class IDCardPresenter extends TBasePresenter<IIDCardView> {
    @Override
    protected void start() {

    }

    public void smAuth(Map<String, String> data) {
        OkGo.post(ServerUrls.ROUTER + "app/addUserImgAz.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .params("sfzzmImg", data.get("sfzzmImg"))
                .params("sfzfmImg", data.get("sfzfmImg"))
                .params("name", data.get("name"))
                .params("sfzhm", data.get("sfzhm"))
                .params("bankcard", data.get("bankcard"))
                .params("zmcards", data.get("zmcards"))
                .params("fmcards", data.get("fmcards"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        BaseRep rep = JSON.parseObject(s, BaseRep.class);
                        if (rep.getCode() == 0) {
                            getView().onAuthOk();
                        } else {
                            getView().onLoadError(rep.getMsg());
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        getView().onLoadError(e.getMessage());
                    }
                });
    }
}
