package com.tt.recyclenow.recyclerList;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tt.recyclenow.R;

import java.util.List;

/**
 * @author tutu
 * @time 2018/6/8
 */

public class RecyclerListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public RecyclerListAdapter(List<String> data) {
        super(R.layout.recycler_list_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
