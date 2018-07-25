package com.tt.recyclenow.mine.guide;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by tu on 2018/7/25.
 */

public class Level0Item extends AbstractExpandableItem<Level1Item> implements MultiItemEntity {
    private String text;

    public Level0Item(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getLevel() {
        return HelpAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
