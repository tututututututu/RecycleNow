package com.tt.recyclenow.mine.guide;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by tu on 2018/7/25.
 */

public class Level1Item implements MultiItemEntity {
    private String text;

    public Level1Item(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getItemType() {
        return HelpAdapter.TYPE_LEVEL_1;
    }
}
