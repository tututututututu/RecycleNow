package com.hzecool.app.bean.event;

/**
 * Created by wangzhiguo on 2017/4/19.
 */

public class SearchNaviEvent extends BaseEvent {

    private int position;
    private String inputContent;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }
}
