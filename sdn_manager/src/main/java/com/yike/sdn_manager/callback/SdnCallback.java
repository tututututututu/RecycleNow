package com.yike.sdn_manager.callback;

import com.yike.sdn_manager.bean.ErrorBean;
import com.yike.sdn_manager.bean.ServerBean;

/**
 * Created by guige on 2018/5/9.
 *  给外部的回调
 */

public interface SdnCallback {


    void onSuccess(ServerBean serverBean);

    void onFailed(ErrorBean bean);

}
