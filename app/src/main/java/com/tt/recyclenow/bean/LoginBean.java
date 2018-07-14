package com.tt.recyclenow.bean;

/**
 * Created by tu on 2018/7/14.
 */

public class LoginBean extends BaseRep{

    /**
     * data : {"userPho":"18670341305","tokens":"20180714104109000"}
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
         * userPho : 18670341305
         * tokens : 20180714104109000
         */

        private String userPho;
        private String tokens;

        public String getUserPho() {
            return userPho;
        }

        public void setUserPho(String userPho) {
            this.userPho = userPho;
        }

        public String getTokens() {
            return tokens;
        }

        public void setTokens(String tokens) {
            this.tokens = tokens;
        }
    }
}
