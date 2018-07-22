package com.tt.recyclenow.auth.person;

import com.tt.recyclenow.bean.PersonAuthBean;
import com.tt.recyclenow.bill.IBillView;

/**
 * Created by tu on 2018/7/18.
 */

public interface IPersonInfoAuth extends IBillView {
    void requestPermision();

    void reFillData(PersonAuthBean rep);
}
