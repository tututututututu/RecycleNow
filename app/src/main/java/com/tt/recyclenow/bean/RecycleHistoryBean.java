package com.tt.recyclenow.bean;

import java.util.List;

/**
 * Created by tu on 2018/7/22.
 */

public class RecycleHistoryBean extends BaseRep{

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * endtimes : 2018-07-24
         * glf : 2
         * id : 10
         * jkje : 1000
         * jktimes : 2018-07-18
         * lx : 315
         * mark : 1
         * pp : 128
         * ts : 7
         * xh : iPhone 7
         */

        private String endtimes;
        private String glf;
        private int id;
        private String jkje;
        private String jktimes;
        private String lx;
        private int mark;
        private String pp;
        private String ts;
        private String xh;

        public String getEndtimes() {
            return endtimes;
        }

        public void setEndtimes(String endtimes) {
            this.endtimes = endtimes;
        }

        public String getGlf() {
            return glf;
        }

        public void setGlf(String glf) {
            this.glf = glf;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJkje() {
            return jkje;
        }

        public void setJkje(String jkje) {
            this.jkje = jkje;
        }

        public String getJktimes() {
            return jktimes;
        }

        public void setJktimes(String jktimes) {
            this.jktimes = jktimes;
        }

        public String getLx() {
            return lx;
        }

        public void setLx(String lx) {
            this.lx = lx;
        }

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }

        public String getPp() {
            return pp;
        }

        public void setPp(String pp) {
            this.pp = pp;
        }

        public String getTs() {
            return ts;
        }

        public void setTs(String ts) {
            this.ts = ts;
        }

        public String getXh() {
            return xh;
        }

        public void setXh(String xh) {
            this.xh = xh;
        }
    }
}
