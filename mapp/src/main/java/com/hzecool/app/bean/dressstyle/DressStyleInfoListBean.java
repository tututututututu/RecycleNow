package com.hzecool.app.bean.dressstyle;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 款号列表
 * Created by tutu on 17/1/9.
 */

public class DressStyleInfoListBean implements Parcelable {

    private List<DressStyleInfo> rows;

    public List<DressStyleInfo> getRows() {
        return rows;
    }

    public void setRows(List<DressStyleInfo> rows) {
        this.rows = rows;
    }

    public static class DressStyleInfo implements Parcelable {
        /**
         * id : 消息id
         * publicTime : 发布时间
         * topic : 描述
         * colorName : 颜色
         * sizeName : 尺码
         * code : 款号
         * name : 名称
         * shopName : 门店
         * shareStateName : 1,已分享 0,未分享
         * price : 价格
         * pictureUrl : ur
         * shopUrl : http: //www.baidu.com/
         */

        private String id;
        private String publicTime;
        private String topic;
        private String colorName;
        private String sizeName;
        private String code;
        private String name;
        private String shopName;
        private String shareStateName;
        private String price;
        private String pictureUrl;
        private String shopUrl;

        @Override
        public String toString() {
            return "RowsBean{" +
                    "id='" + id + '\'' +
                    ", publicTime='" + publicTime + '\'' +
                    ", topic='" + topic + '\'' +
                    ", colorName='" + colorName + '\'' +
                    ", sizeName='" + sizeName + '\'' +
                    ", code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", shopName='" + shopName + '\'' +
                    ", shareStateName='" + shareStateName + '\'' +
                    ", price='" + price + '\'' +
                    ", pictureUrl='" + pictureUrl + '\'' +
                    ", shopUrl='" + shopUrl + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPublicTime() {
            return publicTime;
        }

        public void setPublicTime(String publicTime) {
            this.publicTime = publicTime;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getColorName() {
            return colorName;
        }

        public void setColorName(String colorName) {
            this.colorName = colorName;
        }

        public String getSizeName() {
            return sizeName;
        }

        public void setSizeName(String sizeName) {
            this.sizeName = sizeName;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShareStateName() {
            return shareStateName;
        }

        public void setShareStateName(String shareStateName) {
            this.shareStateName = shareStateName;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public String getShopUrl() {
            return shopUrl;
        }

        public void setShopUrl(String shopUrl) {
            this.shopUrl = shopUrl;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.publicTime);
            dest.writeString(this.topic);
            dest.writeString(this.colorName);
            dest.writeString(this.sizeName);
            dest.writeString(this.code);
            dest.writeString(this.name);
            dest.writeString(this.shopName);
            dest.writeString(this.shareStateName);
            dest.writeString(this.price);
            dest.writeString(this.pictureUrl);
            dest.writeString(this.shopUrl);
        }

        public DressStyleInfo() {
        }

        protected DressStyleInfo(Parcel in) {
            this.id = in.readString();
            this.publicTime = in.readString();
            this.topic = in.readString();
            this.colorName = in.readString();
            this.sizeName = in.readString();
            this.code = in.readString();
            this.name = in.readString();
            this.shopName = in.readString();
            this.shareStateName = in.readString();
            this.price = in.readString();
            this.pictureUrl = in.readString();
            this.shopUrl = in.readString();
        }

        public static final Creator<DressStyleInfo> CREATOR = new Creator<DressStyleInfo>() {
            @Override
            public DressStyleInfo createFromParcel(Parcel source) {
                return new DressStyleInfo(source);
            }

            @Override
            public DressStyleInfo[] newArray(int size) {
                return new DressStyleInfo[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.rows);
    }

    public DressStyleInfoListBean() {
    }

    protected DressStyleInfoListBean(Parcel in) {
        this.rows = new ArrayList<DressStyleInfo>();
        in.readList(this.rows, DressStyleInfo.class.getClassLoader());
    }

    public static final Parcelable.Creator<DressStyleInfoListBean> CREATOR = new Parcelable.Creator<DressStyleInfoListBean>() {
        @Override
        public DressStyleInfoListBean createFromParcel(Parcel source) {
            return new DressStyleInfoListBean(source);
        }

        @Override
        public DressStyleInfoListBean[] newArray(int size) {
            return new DressStyleInfoListBean[size];
        }
    };

    @Override
    public String toString() {
        return "DressStyleInfoListBean{" +
                "rows=" + rows +
                '}';
    }
}
