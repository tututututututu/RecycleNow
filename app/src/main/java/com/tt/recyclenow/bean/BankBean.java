package com.tt.recyclenow.bean;

/**
 * Created by tu on 2018/7/23.
 */

public class BankBean extends BaseRep {

    /**
     * data : {"bankname":"工商银行","bankcard":"xxx"}
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
         * bankname : 工商银行
         * bankcard : xxx
         */

        private String bankname;
        private String bankcard;

        public String getBankname() {
            return bankname;
        }

        public void setBankname(String bankname) {
            this.bankname = bankname;
        }

        public String getBankcard() {
            return bankcard;
        }

        public void setBankcard(String bankcard) {
            this.bankcard = bankcard;
        }
    }
}
