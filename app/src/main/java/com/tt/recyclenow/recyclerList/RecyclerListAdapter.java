package com.tt.recyclenow.recyclerList;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tt.recyclenow.R;
import com.tt.recyclenow.bean.RecycleBean;

import java.util.List;

/**
 * @author tutu
 * @time 2018/6/8
 */

public class RecyclerListAdapter extends BaseQuickAdapter<RecycleBean.DataBean, BaseViewHolder> {

    public RecyclerListAdapter(List<RecycleBean.DataBean> data) {
        super(R.layout.recycler_list_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecycleBean.DataBean item) {
        helper.setText(R.id.tv_name, item.getTitle())
                .setText(R.id.tv_price_day, item.getDqzj())
                .setText(R.id.tv_day, item.getTs())
                .setText(R.id.tv_price, item.getHsze());

    }
}
