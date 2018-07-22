package com.tt.recyclenow.bean;

/**
 * Created by tu on 2018/7/22.
 */

public class PersonAuthBean extends BaseRep{
    /**
     * data : {"sjgxtel1":"13018946767","qsgxtel":"6467767","xl":"大专","userQq":"464646464","gxname1":"外婆婆婆","userEmail":"646464665","userAddr":"明哦破","qsgx":"母亲","gxname":"明敏","sjgx1":"兄弟姐妹","jh":"3-6个月","zn":"自购房未抵押","bz2":"杭州市","bz3":"滨江区","bz1":"浙江省"}
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
         * sjgxtel1 : 13018946767
         * qsgxtel : 6467767
         * xl : 大专
         * userQq : 464646464
         * gxname1 : 外婆婆婆
         * userEmail : 646464665
         * userAddr : 明哦破
         * qsgx : 母亲
         * gxname : 明敏
         * sjgx1 : 兄弟姐妹
         * jh : 3-6个月
         * zn : 自购房未抵押
         * bz2 : 杭州市
         * bz3 : 滨江区
         * bz1 : 浙江省
         */

        private String sjgxtel1;
        private String qsgxtel;
        private String xl;
        private String userQq;
        private String gxname1;
        private String userEmail;
        private String userAddr;
        private String qsgx;
        private String gxname;
        private String sjgx1;
        private String jh;
        private String zn;
        private String bz2;
        private String bz3;
        private String bz1;

        public String getSjgxtel1() {
            return sjgxtel1;
        }

        public void setSjgxtel1(String sjgxtel1) {
            this.sjgxtel1 = sjgxtel1;
        }

        public String getQsgxtel() {
            return qsgxtel;
        }

        public void setQsgxtel(String qsgxtel) {
            this.qsgxtel = qsgxtel;
        }

        public String getXl() {
            return xl;
        }

        public void setXl(String xl) {
            this.xl = xl;
        }

        public String getUserQq() {
            return userQq;
        }

        public void setUserQq(String userQq) {
            this.userQq = userQq;
        }

        public String getGxname1() {
            return gxname1;
        }

        public void setGxname1(String gxname1) {
            this.gxname1 = gxname1;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserAddr() {
            return userAddr;
        }

        public void setUserAddr(String userAddr) {
            this.userAddr = userAddr;
        }

        public String getQsgx() {
            return qsgx;
        }

        public void setQsgx(String qsgx) {
            this.qsgx = qsgx;
        }

        public String getGxname() {
            return gxname;
        }

        public void setGxname(String gxname) {
            this.gxname = gxname;
        }

        public String getSjgx1() {
            return sjgx1;
        }

        public void setSjgx1(String sjgx1) {
            this.sjgx1 = sjgx1;
        }

        public String getJh() {
            return jh;
        }

        public void setJh(String jh) {
            this.jh = jh;
        }

        public String getZn() {
            return zn;
        }

        public void setZn(String zn) {
            this.zn = zn;
        }

        public String getBz2() {
            return bz2;
        }

        public void setBz2(String bz2) {
            this.bz2 = bz2;
        }

        public String getBz3() {
            return bz3;
        }

        public void setBz3(String bz3) {
            this.bz3 = bz3;
        }

        public String getBz1() {
            return bz1;
        }

        public void setBz1(String bz1) {
            this.bz1 = bz1;
        }
    }
}
