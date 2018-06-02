package com.hzecool.core.msgcentre.bean;

/**
 * 商圈你有新的关注请求
 * Created by tutu on 2017/4/24.
 */

public class BussinessMomentFocusMsgEvent {


    /**
     * title : 提示标题
     * text : 内容
     * partner_name : 关注伙伴名称
     */

    private String title;
    private String text;
    private String partner_name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPartner_name() {
        return partner_name;
    }

    public void setPartner_name(String partner_name) {
        this.partner_name = partner_name;
    }
}
