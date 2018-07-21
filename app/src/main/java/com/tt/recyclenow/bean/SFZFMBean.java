package com.tt.recyclenow.bean;

/**
 * @author tutu
 * @time 2018/7/21
 */

public class SFZFMBean {
    private String issued_by;//属于哪个公安局
    private String valid_date;//日期身份证有效日期

    public String getIssued_by() {
        return issued_by;
    }

    public void setIssued_by(String issued_by) {
        this.issued_by = issued_by;
    }

    public String getValid_date() {
        return valid_date;
    }

    public void setValid_date(String valid_date) {
        this.valid_date = valid_date;
    }

    @Override
    public String toString() {
        return "SFZFMBean{" +
                "issued_by='" + issued_by + '\'' +
                ", valid_date='" + valid_date + '\'' +
                '}';
    }
}
