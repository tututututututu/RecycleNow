package com.tt.recyclenow.auth.person;

import com.hzecool.core.base.TIBaseView;
import com.tt.recyclenow.bean.PersonAuthBean;

/**
 * Created by tu on 2018/7/18.
 */

public interface IPersonInfoAuth extends TIBaseView {
    void requestPermision();

    void reFillData(PersonAuthBean rep);
}
