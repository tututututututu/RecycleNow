package com.tt.recyclenow.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by tu on 2018/7/22.
 */

public class RecycleBean extends BaseRep {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * dqzj : 115
         * dzje : 685
         * glf : 50
         * hgze : 1050
         * hsze : 1000
         * id : 4
         * mark : 0
         * time : {"date":18,"day":3,"hours":15,"minutes":40,"month":6,"nanos":370000000,"seconds":23,"time":1531899623370,"timezoneOffset":-480,"year":118}
         * title : 精品回收站二号
         * tj : 0
         * tjrjl : 50
         * ts : 7
         * wyj : 50
         * xq1 : 80
         * xq2 : 160
         * xq3 : 315
         * xsf : 150
         */

        private String dqzj;
        private String dzje;
        private String glf;
        private String hgze;
        private String hsze;
        private int id;
        private int mark;
        private TimeBean time;
        private String title;
        private int tj;
        private String tjrjl;
        private int ts;
        private String wyj;
        private String xq1;
        private String xq2;
        private String xq3;
        private String xsf;

        public String getDqzj() {
            return dqzj;
        }

        public void setDqzj(String dqzj) {
            this.dqzj = dqzj;
        }

        public String getDzje() {
            return dzje;
        }

        public void setDzje(String dzje) {
            this.dzje = dzje;
        }

        public String getGlf() {
            return glf;
        }

        public void setGlf(String glf) {
            this.glf = glf;
        }

        public String getHgze() {
            return hgze;
        }

        public void setHgze(String hgze) {
            this.hgze = hgze;
        }

        public String getHsze() {
            return hsze;
        }

        public void setHsze(String hsze) {
            this.hsze = hsze;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }

        public TimeBean getTime() {
            return time;
        }

        public void setTime(TimeBean time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getTj() {
            return tj;
        }

        public void setTj(int tj) {
            this.tj = tj;
        }

        public String getTjrjl() {
            return tjrjl;
        }

        public void setTjrjl(String tjrjl) {
            this.tjrjl = tjrjl;
        }

        public String getTs() {
            return String.valueOf(ts);
        }

        public void setTs(int ts) {
            this.ts = ts;
        }

        public String getWyj() {
            return wyj;
        }

        public void setWyj(String wyj) {
            this.wyj = wyj;
        }

        public String getXq1() {
            return xq1;
        }

        public void setXq1(String xq1) {
            this.xq1 = xq1;
        }

        public String getXq2() {
            return xq2;
        }

        public void setXq2(String xq2) {
            this.xq2 = xq2;
        }

        public String getXq3() {
            return xq3;
        }

        public void setXq3(String xq3) {
            this.xq3 = xq3;
        }

        public String getXsf() {
            return xsf;
        }

        public void setXsf(String xsf) {
            this.xsf = xsf;
        }

        public static class TimeBean implements Parcelable {
            /**
             * date : 18
             * day : 3
             * hours : 15
             * minutes : 40
             * month : 6
             * nanos : 370000000
             * seconds : 23
             * time : 1531899623370
             * timezoneOffset : -480
             * year : 118
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int nanos;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getNanos() {
                return nanos;
            }

            public void setNanos(int nanos) {
                this.nanos = nanos;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.date);
                dest.writeInt(this.day);
                dest.writeInt(this.hours);
                dest.writeInt(this.minutes);
                dest.writeInt(this.month);
                dest.writeInt(this.nanos);
                dest.writeInt(this.seconds);
                dest.writeLong(this.time);
                dest.writeInt(this.timezoneOffset);
                dest.writeInt(this.year);
            }

            public TimeBean() {
            }

            protected TimeBean(Parcel in) {
                this.date = in.readInt();
                this.day = in.readInt();
                this.hours = in.readInt();
                this.minutes = in.readInt();
                this.month = in.readInt();
                this.nanos = in.readInt();
                this.seconds = in.readInt();
                this.time = in.readLong();
                this.timezoneOffset = in.readInt();
                this.year = in.readInt();
            }

            public static final Creator<TimeBean> CREATOR = new Creator<TimeBean>() {
                @Override
                public TimeBean createFromParcel(Parcel source) {
                    return new TimeBean(source);
                }

                @Override
                public TimeBean[] newArray(int size) {
                    return new TimeBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.dqzj);
            dest.writeString(this.dzje);
            dest.writeString(this.glf);
            dest.writeString(this.hgze);
            dest.writeString(this.hsze);
            dest.writeInt(this.id);
            dest.writeInt(this.mark);
            dest.writeParcelable(this.time, flags);
            dest.writeString(this.title);
            dest.writeInt(this.tj);
            dest.writeString(this.tjrjl);
            dest.writeInt(this.ts);
            dest.writeString(this.wyj);
            dest.writeString(this.xq1);
            dest.writeString(this.xq2);
            dest.writeString(this.xq3);
            dest.writeString(this.xsf);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.dqzj = in.readString();
            this.dzje = in.readString();
            this.glf = in.readString();
            this.hgze = in.readString();
            this.hsze = in.readString();
            this.id = in.readInt();
            this.mark = in.readInt();
            this.time = in.readParcelable(TimeBean.class.getClassLoader());
            this.title = in.readString();
            this.tj = in.readInt();
            this.tjrjl = in.readString();
            this.ts = in.readInt();
            this.wyj = in.readString();
            this.xq1 = in.readString();
            this.xq2 = in.readString();
            this.xq3 = in.readString();
            this.xsf = in.readString();
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
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
}
