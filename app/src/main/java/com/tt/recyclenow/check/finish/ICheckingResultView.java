package com.tt.recyclenow.check.finish;

import com.hzecool.core.base.TIBaseView;
import com.tt.recyclenow.bean.AuthStatusBean;

/**
 * @author tutu
 * @time 2018/6/6
 */

public interface ICheckingResultView extends TIBaseView {
    void onAuthStatusOk(AuthStatusBean bean);
}
