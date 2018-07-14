package com.tt.recyclenow.account.regist;

import com.hzecool.core.base.TIBaseView;

/**
 * @author tutu
 * @time 2018/6/12
 */

public interface IRegisterView extends TIBaseView {
    String getCode();
    String getPhone();
    String getPsw();
    void registOk();
    void getCodeOk();
}
