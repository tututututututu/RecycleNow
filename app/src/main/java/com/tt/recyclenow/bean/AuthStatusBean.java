package com.tt.recyclenow.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * Created by tu on 2018/7/18.
 */

public class AuthStatusBean extends BaseRep implements Parcelable {

    /**
     * data : {"grMark":"0","phoneUrl":"app/phoneRzUrl.htm","dlwzMark":"0","tbUrl":"app/tbRzUrl.htm","xxxs":"1","nameMark":0,"bankcard":null,"tbMark":"0","phonexs":"1","tbxs":"1","xxMark":"0","txlMark":"0","xxUrl":"app/xxRzUrl.htm","phoneMark":"0"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * grMark : 0
         * phoneUrl : app/phoneRzUrl.htm
         * dlwzMark : 0
         * tbUrl : app/tbRzUrl.htm
         * xxxs : 1
         * nameMark : 0
         * bankcard : null
         * tbMark : 0
         * phonexs : 1
         * tbxs : 1
         * xxMark : 0
         * txlMark : 0
         * xxUrl : app/xxRzUrl.htm
         * phoneMark : 0
         */

        private String grMark;
        private String phoneUrl;
        private String dlwzMark;
        private String tbUrl;
        private String xxxs;
        private String nameMark;
        private String bankcard;
        private String tbMark;
        private String phonexs;
        private String tbxs;
        private String xxMark;
        private String txlMark;
        private String xxUrl;
        private String phoneMark;

        public String getGrMark() {
            return grMark;
        }

        public void setGrMark(String grMark) {
            this.grMark = grMark;
        }

        public String getPhoneUrl() {
            return phoneUrl;
        }

        public void setPhoneUrl(String phoneUrl) {
            this.phoneUrl = phoneUrl;
        }

        public String getDlwzMark() {
            return dlwzMark;
        }

        public void setDlwzMark(String dlwzMark) {
            this.dlwzMark = dlwzMark;
        }

        public String getTbUrl() {
            return tbUrl;
        }

        public void setTbUrl(String tbUrl) {
            this.tbUrl = tbUrl;
        }

        public String getXxxs() {
            return xxxs;
        }

        public void setXxxs(String xxxs) {
            this.xxxs = xxxs;
        }

        public String getNameMark() {
            return nameMark;
        }

        public void setNameMark(String nameMark) {
            this.nameMark = nameMark;
        }

        public Object getBankcard() {
            return bankcard;
        }

        public void setBankcard(String bankcard) {
            this.bankcard = bankcard;
        }

        public String getTbMark() {
            return tbMark;
        }

        public void setTbMark(String tbMark) {
            this.tbMark = tbMark;
        }

        public String getPhonexs() {
            return phonexs;
        }

        public void setPhonexs(String phonexs) {
            this.phonexs = phonexs;
        }

        public String getTbxs() {
            return tbxs;
        }

        public void setTbxs(String tbxs) {
            this.tbxs = tbxs;
        }

        public String getXxMark() {
            return xxMark;
        }

        public void setXxMark(String xxMark) {
            this.xxMark = xxMark;
        }

        public String getTxlMark() {
            return txlMark;
        }

        public void setTxlMark(String txlMark) {
            this.txlMark = txlMark;
        }

        public String getXxUrl() {
            return xxUrl;
        }

        public void setXxUrl(String xxUrl) {
            this.xxUrl = xxUrl;
        }

        public String getPhoneMark() {
            return phoneMark;
        }

        public void setPhoneMark(String phoneMark) {
            this.phoneMark = phoneMark;
        }

        public boolean needAuth() {

            if ("1".equals(getNameMark()) &&
                    "1".equals(getGrMark()) &&
                    (("0".equals(getPhonexs()) && "2".equals(getPhoneMark())) ||
                            "1".equals(getPhonexs())) &&
                    (("0".equals(getTbxs()) && "2".equals(getTbMark())) ||
                            "1".equals(getTbxs())) &&
                    "1".equals(getTxlMark()) &&
                    "1".equals(getDlwzMark()) &&
                    !TextUtils.isEmpty(bankcard) &&
                    (("0".equals(getXxxs()) && "2".equals(getXxMark())) ||
                            "1".equals(getXxxs()))
                    ) {
                return false;
            }

            return true;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.grMark);
            dest.writeString(this.phoneUrl);
            dest.writeString(this.dlwzMark);
            dest.writeString(this.tbUrl);
            dest.writeString(this.xxxs);
            dest.writeString(this.nameMark);
            dest.writeString(this.bankcard);
            dest.writeString(this.tbMark);
            dest.writeString(this.phonexs);
            dest.writeString(this.tbxs);
            dest.writeString(this.xxMark);
            dest.writeString(this.txlMark);
            dest.writeString(this.xxUrl);
            dest.writeString(this.phoneMark);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.grMark = in.readString();
            this.phoneUrl = in.readString();
            this.dlwzMark = in.readString();
            this.tbUrl = in.readString();
            this.xxxs = in.readString();
            this.nameMark = in.readString();
            this.bankcard = in.readString();
            this.tbMark = in.readString();
            this.phonexs = in.readString();
            this.tbxs = in.readString();
            this.xxMark = in.readString();
            this.txlMark = in.readString();
            this.xxUrl = in.readString();
            this.phoneMark = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
    }

    public AuthStatusBean() {
    }

    protected AuthStatusBean(Parcel in) {
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<AuthStatusBean> CREATOR = new Parcelable.Creator<AuthStatusBean>() {
        @Override
        public AuthStatusBean createFromParcel(Parcel source) {
            return new AuthStatusBean(source);
        }

        @Override
        public AuthStatusBean[] newArray(int size) {
            return new AuthStatusBean[size];
        }
    };
}
