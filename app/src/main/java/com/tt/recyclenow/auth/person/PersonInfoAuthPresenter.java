package com.tt.recyclenow.auth.person;

import android.text.TextUtils;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.common.utils.Utils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.Constants;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.auth.person.contact.ContactBean;
import com.tt.recyclenow.auth.person.contact.ContactGetHelper;
import com.tt.recyclenow.bean.BaseRep;
import com.tt.recyclenow.bean.PersonAuthBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by tu on 2018/7/18.
 */

public class PersonInfoAuthPresenter extends TBasePresenter<IPersonInfoAuth> {
    private List<ContactBean> contactBeanList = new ArrayList<>();
    private String lng = "";
    private String lat = "";

    @Override
    protected void start() {
        getData();
        getView().requestPermision();
    }

    public void permissionOk() {
        contactBeanList = ContactGetHelper.getContacts(Utils.getContext().getApplicationContext());
        requestLocation();
    }

    public void upLoadData(Map<String, String> params) {

        if (!checkParams(params)) {
            permissionOk();
            return;
        }

        OkGo.post(ServerUrls.ROUTER + "app/addUserinformation.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .params("lng", lng)
                .params("lat", lat)
                .params(params)
                .params("datas", JSON.toJSONString(this.contactBeanList))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        BaseRep rep = JSON.parseObject(s, BaseRep.class);
                        if (rep.getCode() == 0) {
                            getView().onLoadData(rep);
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

    private void requestLocation() {
        String lng = SPUtils.getString(Constants.LNG);
        String lat = SPUtils.getString(Constants.LAT);

        if ("4.9E-324".equals(lng) || "4.9E-324".equals(lat)) {
            Toast.makeText(Utils.getContext(), "正在定位", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(lng) || TextUtils.isEmpty(lat)) {
            Toast.makeText(Utils.getContext(), "定位失败", Toast.LENGTH_SHORT).show();
            return;
        }

        this.lat = lat;
        this.lng = lng;
    }

    private boolean checkParams(Map<String, String> params) {
        if (TextUtils.isEmpty(params.get("userEmail"))) {
            ToastUtils.showShortToast("微信不能为空");
            return false;
        }
        if (TextUtils.isEmpty(params.get("userQq"))) {
            ToastUtils.showShortToast("QQ不能为空");
            return false;
        }
        if (TextUtils.isEmpty(params.get("zn"))) {
            ToastUtils.showShortToast("住房情况不能为空");
            return false;
        }
        if (TextUtils.isEmpty(params.get("xl"))) {
            ToastUtils.showShortToast("文化情况不能为空");
            return false;
        }
        if (TextUtils.isEmpty(params.get("jh"))) {
            ToastUtils.showShortToast("居住时长不能为空");
            return false;
        }
        if (TextUtils.isEmpty(params.get("bz1")) ||
                TextUtils.isEmpty(params.get("bz2")) ||
                TextUtils.isEmpty(params.get("bz3")) ||
                TextUtils.isEmpty(params.get("userAddr"))) {
            ToastUtils.showShortToast("居住地址不能为空");
            return false;
        }
        if (TextUtils.isEmpty(params.get("userEmail"))) {
            ToastUtils.showShortToast("微信不能为空");
            return false;
        }
        if (TextUtils.isEmpty(params.get("qsgx")) ||
                TextUtils.isEmpty(params.get("gxname")) ||
                TextUtils.isEmpty(params.get("qsgxtel"))) {
            ToastUtils.showShortToast("联系关系1不能为空");
            return false;
        }

        if (TextUtils.isEmpty(params.get("sjgx1")) ||
                TextUtils.isEmpty(params.get("gxname1")) ||
                TextUtils.isEmpty(params.get("sjgxtel1"))) {
            ToastUtils.showShortToast("联系关系1不能为空");
            return false;
        }


        if (TextUtils.isEmpty(this.lat) ||
                TextUtils.isEmpty(this.lng)) {
            ToastUtils.showShortToast("请打开app位置权限,并打开位置服务后重试");
            return false;
        }

        if (this.contactBeanList == null || this.contactBeanList.isEmpty()) {
            ToastUtils.showShortToast("请打开app读取联系人权限后重试");
            return false;
        }

        return true;
    }


    public void getData(){

        OkGo.post(ServerUrls.ROUTER + "app/getUserinformation.htm")
                .params("tokens", SPUtils.getString(Constants.SP_TOKENDS))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        PersonAuthBean rep = JSON.parseObject(s, PersonAuthBean.class);
                        if (rep.getCode() == 0) {
                            getView().reFillData(rep);
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
