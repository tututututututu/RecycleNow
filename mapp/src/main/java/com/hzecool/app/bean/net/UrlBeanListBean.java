package com.hzecool.app.bean.net;


import java.util.List;

/**
 * url实体类
 * Created by tutu on 2017/3/1.
 */

public class UrlBeanListBean {

    private List<UrlBean> rows;

    public List<UrlBean> getRows() {
        return rows;
    }

    public void setRows(List<UrlBean> rows) {
        this.rows = rows;
    }

    public static class UrlBean {
        /**
         * domainUrl : https://sassist.hzdlsoft.com/slh
         * ipUrl : https://sassist.hzdlsoft.com/slh
         * name : 网银
         */

        private String domainUrl;
        private String ipUrl;
        private String name;
        private String sslFlag;


        public String getSslFlag() {
            return sslFlag;
        }

        public void setSslFlag(String sslFlag) {
            this.sslFlag = sslFlag;
        }

        public String getDomainUrl() {
            return domainUrl;
        }

        public void setDomainUrl(String domainUrl) {
            this.domainUrl = domainUrl;
        }

        public String getIpUrl() {
            return ipUrl;
        }

        public void setIpUrl(String ipUrl) {
            this.ipUrl = ipUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "UrlBean{" +
                    "domainUrl='" + domainUrl + '\'' +
                    ", ipUrl='" + ipUrl + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
