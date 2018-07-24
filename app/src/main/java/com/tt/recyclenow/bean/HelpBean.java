package com.tt.recyclenow.bean;

import java.util.List;

/**
 * Created by tu on 2018/7/24.
 */

public class HelpBean extends BaseRep {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 学信网授权协议
         * cont : LY完善的服务，我们会在必要时向合作机构共享您的相<span 耐心等候</p>
         */

        private String title;
        private String cont;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCont() {
            return cont;
        }

        public void setCont(String cont) {
            this.cont = cont;
        }
    }
}
