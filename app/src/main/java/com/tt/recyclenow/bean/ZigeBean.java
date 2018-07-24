package com.tt.recyclenow.bean;

/**
 * Created by tu on 2018/7/24.
 */

public class ZigeBean extends BaseRep {

    /**
     * data : {"closeMark":"0"}
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
         * closeMark : 0
         */

        private String closeMark;

        public String getCloseMark() {
            return closeMark;
        }

        public void setCloseMark(String closeMark) {
            this.closeMark = closeMark;
        }
    }
}
