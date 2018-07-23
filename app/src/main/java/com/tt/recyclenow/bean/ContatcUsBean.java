package com.tt.recyclenow.bean;

/**
 * Created by tu on 2018/7/23.
 */

public class ContatcUsBean extends BaseRep{

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * lxfknr : <p style="TEXT-ALIGN: left; LINE-HEIGHT: 2em"><span style="FONT-SIZE: 20px"><img src="/ueditor/jsp/upload1/20180717/301531835800145.png"/></span></p><p>仔细阅读还款流程，有助于您快速还款32323</p><p style="text-align: center;">&nbsp;</p><p><span style="FONT-FAMILY: Times New Roman"></span></p>
         */

        private String lxfknr;

        public String getLxfknr() {
            return lxfknr;
        }

        public void setLxfknr(String lxfknr) {
            this.lxfknr = lxfknr;
        }
    }
}
