package com.tt.recyclenow.index;

import com.hzecool.core.base.TIBaseView;
import com.tt.recyclenow.bean.IndexBanner;
import com.tt.recyclenow.bean.PhonePriceBean;

/**
 * @author tutu
 * @time 2018/6/3
 */

public interface IIndexView extends TIBaseView {
    void BannerOk(IndexBanner indexBanner);

    void PhonePriceOk(PhonePriceBean rep);

    void PhonePriceFail(PhonePriceBean rep);
}
