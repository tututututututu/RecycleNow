package com.hzecool.app.bean.user;

import android.os.Parcel;
import android.os.Parcelable;

import com.hzecool.app.bean.dressstyle.EnterPriseInfoBean;

/**
 * 用户信息
 * Created by tutu on 17/1/9.
 */
public class UserInfoBean implements Parcelable {
    private String sessionId;//会话id
    private String userId;//用户id
    private String loginName;//登录名
    private String mobile;//手机号
    private String userName;//用户名
    private String nickName;//昵称
    private String photoUrl;//照片
    private String docUploadUrl;//上传图片路径
    private EnterPriseInfoBean staff;//当前企业信息


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDocUploadUrl() {
        return docUploadUrl;
    }

    public void setDocUploadUrl(String docUploadUrl) {
        this.docUploadUrl = docUploadUrl;
    }

    public EnterPriseInfoBean getStaff() {
        return staff;
    }

    public void setStaff(EnterPriseInfoBean staff) {
        this.staff = staff;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sessionId);
        dest.writeString(this.userId);
        dest.writeString(this.loginName);
        dest.writeString(this.mobile);
        dest.writeString(this.userName);
        dest.writeString(this.nickName);
        dest.writeString(this.photoUrl);
        dest.writeString(this.docUploadUrl);
        dest.writeParcelable(this.staff, flags);
    }

    public UserInfoBean() {
    }

    protected UserInfoBean(Parcel in) {
        this.sessionId = in.readString();
        this.userId = in.readString();
        this.loginName = in.readString();
        this.mobile = in.readString();
        this.userName = in.readString();
        this.nickName = in.readString();
        this.photoUrl = in.readString();
        this.docUploadUrl = in.readString();
        this.staff = in.readParcelable(EnterPriseInfoBean.class.getClassLoader());
    }

    public static final Creator<UserInfoBean> CREATOR = new Creator<UserInfoBean>() {
        @Override
        public UserInfoBean createFromParcel(Parcel source) {
            return new UserInfoBean(source);
        }

        @Override
        public UserInfoBean[] newArray(int size) {
            return new UserInfoBean[size];
        }
    };

    @Override
    public String toString() {
        return "UserInfoBean{" +
                "sessionId='" + sessionId + '\'' +
                ", userId='" + userId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", docUploadUrl='" + docUploadUrl + '\'' +
                ", staff=" + staff +
                '}';
    }
}
