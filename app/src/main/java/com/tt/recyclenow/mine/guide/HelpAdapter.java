package com.tt.recyclenow.mine.guide;

import android.text.Html;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.tt.recyclenow.R;

import java.util.List;

/**
 * Created by tu on 2018/7/24.
 */

public class HelpAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;

    public HelpAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.help_item1);
        addItemType(TYPE_LEVEL_1, R.layout.help_item);
    }

    @Override
    protected void convert(BaseViewHolder helper,  final MultiItemEntity item) {

        switch (helper.getItemViewType()){
            case TYPE_LEVEL_0:
                final Level0Item lv0 = (Level0Item) item;
                helper.setText(R.id.tv, lv0.getText());

                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        Log.d(TAG, "Level 0 item pos: " + pos);
                        if (lv0.isExpanded()) {
                            collapse(pos);
                        } else {
//                            if (pos % 3 == 0) {
//                                expandAll(pos, false);
//                            } else {
                            expand(pos);
//                            }
                        }
                    }
                });
                break;
            case TYPE_LEVEL_1:
                final Level1Item lv1 = (Level1Item) item;
                helper.setText(R.id.tv, Html.fromHtml(lv1.getText()));
                break;
        }


    }
}
