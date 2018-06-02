package com.hzecool.app.bean.dressstyle;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tutu on 17/1/9.
 * 企业信息bean
 */

public class EnterPriseInfoBean implements Parcelable {


    private String openId;
    private String openName;
    private String staffId;
    private String staffNo;
    private boolean isCheak;

    public boolean isCheak() {
        return isCheak;
    }

    public void setCheak(boolean cheak) {
        isCheak = cheak;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenName() {
        return openName;
    }

    public void setOpenName(String openName) {
        this.openName = openName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public EnterPriseInfoBean() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.openId);
        dest.writeString(this.openName);
        dest.writeString(this.staffId);
        dest.writeString(this.staffNo);
        dest.writeByte(this.isCheak ? (byte) 1 : (byte) 0);
    }

    protected EnterPriseInfoBean(Parcel in) {
        this.openId = in.readString();
        this.openName = in.readString();
        this.staffId = in.readString();
        this.staffNo = in.readString();
        this.isCheak = in.readByte() != 0;
    }

    public static final Creator<EnterPriseInfoBean> CREATOR = new Creator<EnterPriseInfoBean>() {
        @Override
        public EnterPriseInfoBean createFromParcel(Parcel source) {
            return new EnterPriseInfoBean(source);
        }

        @Override
        public EnterPriseInfoBean[] newArray(int size) {
            return new EnterPriseInfoBean[size];
        }
    };

    @Override
    public String toString() {
        return "EnterPriseInfoBean{" +
                "openId='" + openId + '\'' +
                ", openName='" + openName + '\'' +
                ", staffId='" + staffId + '\'' +
                ", staffNo='" + staffNo + '\'' +
                ", isCheak=" + isCheak +
                '}';
    }
}
