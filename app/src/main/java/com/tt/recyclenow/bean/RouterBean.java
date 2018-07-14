package com.tt.recyclenow.bean;

/**
 * Created by tu on 2018/7/14.
 */

public class RouterBean extends BaseRep {

    /**
     * data : {"url":"https://www.qumiaodai.cn/"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * url : https://www.qumiaodai.cn/
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
