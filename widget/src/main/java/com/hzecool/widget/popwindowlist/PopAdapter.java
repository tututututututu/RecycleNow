package com.hzecool.widget.popwindowlist;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hzecool.widget.R;

import java.util.List;

/**
 *
 * @author tutu
 * @date 2017/4/17
 */

public class PopAdapter extends BaseQuickAdapter<PopItemTypeInfoBean, BaseViewHolder> {


    public PopAdapter(int resId, List<PopItemTypeInfoBean> data) {
        super(resId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PopItemTypeInfoBean item) {
        helper.setText(R.id.tv, item.getName());
    }
}
