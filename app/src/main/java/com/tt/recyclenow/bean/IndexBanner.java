package com.tt.recyclenow.bean;

import java.util.List;

/**
 * Created by tu on 2018/7/14.
 */

public class IndexBanner extends BaseRep{

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * img : https://www.qumiaodai.cn/adverImg/1.jpg
         * url : #
         */

        private String img;
        private String url;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
