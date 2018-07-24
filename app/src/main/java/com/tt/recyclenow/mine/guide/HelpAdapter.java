package com.tt.recyclenow.mine.guide;

import android.text.Html;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tt.recyclenow.R;

import java.util.List;

/**
 * Created by tu on 2018/7/24.
 */

public class HelpAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public HelpAdapter(List<String> data) {
        super(R.layout.help_item,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv, Html.fromHtml(item));
    }
}
