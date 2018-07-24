package com.tt.recyclenow.auth.main;

import com.hzecool.core.base.TIBaseView;
import com.tt.recyclenow.bean.AuthStatusBean;

/**
 * @author tutu
 * @time 2018/6/7
 */

public interface IAuthView extends TIBaseView{
    void onAuthStatusOk(AuthStatusBean bean);

    void onGetAuthUrlOk(String url);

    void canNext();
}
