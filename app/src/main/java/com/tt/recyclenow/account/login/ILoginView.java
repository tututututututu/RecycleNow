package com.tt.recyclenow.account.login;

import com.hzecool.core.base.TIBaseView;
import com.tt.recyclenow.bean.LoginBean;

/**
 * Created by tu on 2018/6/9.
 */

public interface ILoginView extends TIBaseView{
    void loginOk(LoginBean rep);

    String getPhone();

    String getPsw();
}
