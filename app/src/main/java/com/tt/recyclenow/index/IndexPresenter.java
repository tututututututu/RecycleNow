package com.tt.recyclenow.index;

import com.hzecool.common.json.GsonUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.base.TBasePresenter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.BaseRep;
import com.tt.recyclenow.bean.IndexBanner;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author tutu
 * @time 2018/6/3
 */

public class IndexPresenter extends TBasePresenter<IIndexView> {
    @Override
    protected void start() {
        getBanner();
    }

    public void getBanner(){
        OkGo.post(ServerUrls.ROUTER + "app/adverList.htm")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        BaseRep rep = GsonUtils.jsonToObj(s, BaseRep.class);
                        if (rep.getCode() == 0) {
                            IndexBanner indexBanner = GsonUtils.jsonToObj(s,IndexBanner.class);
                            getView().BannerOk(indexBanner);
                        } else {
                            ToastUtils.showShortToast(rep.getMsg());
                        }
                    }
                });
    }
}
