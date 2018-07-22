package com.tt.recyclenow.recycleHistory;

import android.graphics.Color;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tt.recyclenow.R;
import com.tt.recyclenow.bean.RecycleHistoryBean;

import java.util.List;

/**
 * @author tutu
 * @time 2018/6/8
 */

public class HistoryAdapter extends BaseQuickAdapter<RecycleHistoryBean.DataBean, BaseViewHolder> {

    public HistoryAdapter(List<RecycleHistoryBean.DataBean> data) {
        super(R.layout.history_list_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecycleHistoryBean.DataBean item) {
        helper.setText(R.id.tv_1, item.getJkje())
                .setText(R.id.tv_2, item.getTs())

                .setText(R.id.tv_4, TextUtils.isEmpty(item.getJktimes()) ? "----" : item.getJktimes())
                .setText(R.id.tv_5, TextUtils.isEmpty(item.getEndtimes()) ? "----" : item.getEndtimes());

        if (item.getTs().equals("0")){
            helper.setText(R.id.tv_3,"新申请");
            helper.setTextColor(R.id.tv_3, Color.BLUE);
        }else if (item.getTs().equals("1")){
            helper.setText(R.id.tv_3, "通过");
            helper.setTextColor(R.id.tv_3, Color.GREEN);
        }else if (item.getTs().equals("2")){
            helper.setText(R.id.tv_3, "未通过");
            helper.setTextColor(R.id.tv_3, Color.GRAY);
        }else if (item.getTs().equals("3")){
            helper.setText(R.id.tv_3, "已完结");
            helper.setTextColor(R.id.tv_3, Color.GRAY);
        }else if (item.getTs().equals("4")){
            helper.setText(R.id.tv_3, "取消");
            helper.setTextColor(R.id.tv_3, Color.GRAY);
        }else if (item.getTs().equals("6")){
            helper.setText(R.id.tv_3, "审核中");
            helper.setTextColor(R.id.tv_3, Color.YELLOW);
        }

    }
}
