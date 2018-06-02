package com.hzecool.core.msgcentre.bean;

/**
 * 消息中心消息的基类
 *
 * @author tutu
 * @date 2017/4/24
 */

public class BaseMsgCentreEventBean {
    /**
     * from : {"sid":"会话id","guid":"全局通讯识别号","cCode":"渠道编码","pid":"渠道内端点"}
     * to : {"sid":"会话id","guid":"全局通讯识别号","cCode":"渠道编码","pid":"渠道内端点"}
     * metas : {"isRing":true,"isVibrate":true,"autoBadge":"+1","isShowAlert":true}
     * msgBean : {"id":"消息id","zip":"消息压缩方式","rli":"消息可靠性","pri":"消息优先级","time":"消息发送时间,格式如:2017-03-28 15:53:01","bizType":"业务类型","type":"技术类型","body":{}}
     */

    private FromBean from;
    private ToBean to;
    private MetasBean metas;
    private MsgContentBean msgBean;

    public FromBean getFrom() {
        return from;
    }

    public void setFrom(FromBean from) {
        this.from = from;
    }

    public ToBean getTo() {
        return to;
    }

    public void setTo(ToBean to) {
        this.to = to;
    }

    public MetasBean getMetas() {
        return metas;
    }

    public void setMetas(MetasBean metas) {
        this.metas = metas;
    }

    public MsgContentBean getMsgBean() {
        return msgBean;
    }

    public void setMsgBean(MsgContentBean msgBean) {
        this.msgBean = msgBean;
    }

    public static class FromBean {
        /**
         * sid : 会话id
         * guid : 全局通讯识别号
         * cCode : 渠道编码
         * pid : 渠道内端点
         */

        private String sid;
        private String guid;
        private String cCode;
        private String pid;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getCCode() {
            return cCode;
        }

        public void setCCode(String cCode) {
            this.cCode = cCode;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        @Override
        public String toString() {
            return "FromBean{" +
                    "sid='" + sid + '\'' +
                    ", guid='" + guid + '\'' +
                    ", cCode='" + cCode + '\'' +
                    ", pid='" + pid + '\'' +
                    '}';
        }
    }

    public static class ToBean {
        /**
         * sid : 会话id
         * guid : 全局通讯识别号
         * cCode : 渠道编码
         * pid : 渠道内端点
         */

        private String sid;
        private String guid;
        private String cCode;
        private String pid;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public String getCCode() {
            return cCode;
        }

        public void setCCode(String cCode) {
            this.cCode = cCode;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        @Override
        public String toString() {
            return "ToBean{" +
                    "sid='" + sid + '\'' +
                    ", guid='" + guid + '\'' +
                    ", cCode='" + cCode + '\'' +
                    ", pid='" + pid + '\'' +
                    '}';
        }
    }

    public static class MetasBean {
        /**
         * isRing : true
         * isVibrate : true
         * autoBadge : +1
         * isShowAlert : true
         */

        private boolean isRing;
        private boolean isVibrate;
        private String autoBadge;
        private boolean isShowAlert;

        public boolean isIsRing() {
            return isRing;
        }

        public void setIsRing(boolean isRing) {
            this.isRing = isRing;
        }

        public boolean isIsVibrate() {
            return isVibrate;
        }

        public void setIsVibrate(boolean isVibrate) {
            this.isVibrate = isVibrate;
        }

        public String getAutoBadge() {
            return autoBadge;
        }

        public void setAutoBadge(String autoBadge) {
            this.autoBadge = autoBadge;
        }

        public boolean isIsShowAlert() {
            return isShowAlert;
        }

        public void setIsShowAlert(boolean isShowAlert) {
            this.isShowAlert = isShowAlert;
        }

        @Override
        public String toString() {
            return "MetasBean{" +
                    "isRing=" + isRing +
                    ", isVibrate=" + isVibrate +
                    ", autoBadge='" + autoBadge + '\'' +
                    ", isShowAlert=" + isShowAlert +
                    '}';
        }
    }

    public static class MsgContentBean {
        /**
         * id : 消息id
         * zip : 消息压缩方式
         * rli : 消息可靠性
         * pri : 消息优先级
         * time : 消息发送时间,格式如:2017-03-28 15:53:01
         * bizType : 业务类型
         * type : 技术类型
         * body : {}
         */

        private String id;
        private String zip;
        private String rli;
        private String pri;
        private String time;
        private String bizType;
        private String type;
        private UploadLogMsgBean body;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public String getRli() {
            return rli;
        }

        public void setRli(String rli) {
            this.rli = rli;
        }

        public String getPri() {
            return pri;
        }

        public void setPri(String pri) {
            this.pri = pri;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getBizType() {
            return bizType;
        }

        public void setBizType(String bizType) {
            this.bizType = bizType;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public UploadLogMsgBean getBody() {
            return body;
        }

        public void setBody(UploadLogMsgBean body) {
            this.body = body;
        }

        public static class BodyBean {
        }

        @Override
        public String toString() {
            return "MsgContentBean{" +
                    "id='" + id + '\'' +
                    ", zip='" + zip + '\'' +
                    ", rli='" + rli + '\'' +
                    ", pri='" + pri + '\'' +
                    ", time='" + time + '\'' +
                    ", bizType='" + bizType + '\'' +
                    ", type='" + type + '\'' +
                    ", body=" + body +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BaseMsgCentreEventBean{" +
                "from=" + from +
                ", to=" + to +
                ", metas=" + metas +
                ", msgBean=" + msgBean +
                '}';
    }
}
