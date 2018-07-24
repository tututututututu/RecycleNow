package com.tt.recyclenow.bean;

/**
 * @author tutu
 * @time 2018/7/14
 */

public class PhonePriceBean extends BaseRep {

    /**
     * data : {"price":"6000","hsprice":4500}
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
         * price : 6000
         * hsprice : 4500
         */

        private String price;
        private int hsprice;
        private String mark;

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getHsprice() {
            return hsprice;
        }

        public void setHsprice(int hsprice) {
            this.hsprice = hsprice;
        }
    }
}
