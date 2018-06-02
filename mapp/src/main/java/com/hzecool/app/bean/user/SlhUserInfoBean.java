package com.hzecool.app.bean.user;

import android.text.TextUtils;

import com.hzecool.app.bean.dict.BaseNetResponseBean;
import com.hzecool.common.utils.SpliteStringUtils;

import java.util.List;

/**
 * @author tutu
 * @date 2017/4/12
 */

public class SlhUserInfoBean extends BaseNetResponseBean {
    /**
     * topurl : http://115.231.110.253:7080/mycrm/DocShowBySN?sn=000018&optime=1489372832000
     * erpname : 批发测试
     * openname : 东灵女装批发商
     * sn : 1400221154483
     * invname : 常青店
     * partialSn : 21154483
     * compid : 5
     * tallyflag : 0
     * powerids : 200,20000,20001,20001-1,20001-2,20001-3,20002,20011,20011-1,20011-2,20011-3,20012,20013,20014,20020,20021,20024,20027,20030,20034,20060,20061,20062,20064,20065,20067,20068,20069,20070,20071,20072,20080,20081,20082,20083,20084,210,21001,21001-1,21001-2,21001-3,21002,21003,21003-1,21003-2,21003-3,21004,21005,21007,21060,21062,21063,21065,21080,21081,21082,21083,220,22001,22001-1,22001-2,22001-3,22002,22004,22021,22021-1,22022,22022-1,22022-2,22023,22024,22031,22031-1,22031-2,22031-3,22032,22033,22034,22035,22036,230,23001,23003,23004,23008,23009,23011,23012,23013,23020,23021,23022,23022-1,23022-2,23022-3,23023,23024,23026,23032,23033,23034,23035,23041,231,232,240,24001,24001-1,24001-2,24001-3,24001-4,24002,24002-1,24002-2,24002-3,24002-4,24003,24003-1,24003-2,24003-3,24003-4,24004,24004-1,24004-2,24004-3,24004-4,24005,24005-1,24005-2,24005-3,24005-4,24006,24006-1,24006-2,24006-3,24006-4,24007,24007-1,24007-2,24007-3,24007-4,24008,24008-1,24008-2,24008-3,24008-4,24009,24009-1,24009-2,24009-3,24009-4,24010,24010-1,24010-2,24011,24011-1,24012,24012-1,24012-2,24012-3,24012-4,24013,24014,24015,24015-2,250,25001,25002,25003,25004,25004-3,25005,25006,25007,25008,25009,25010,25011,25012,25013,25013-1,25013-3,25013-4,25013-5,25014,25014-2,25014-3,25015,25015-1,25015-2,25015-3,25017,25018,25019,25020,25021
     * code : 0411
     * sessionid : 57235996-9094-A3E4-8968-3BCB4EBFB105
     * id : 316929
     * invid : 3
     * epid : 3
     * rolename : 总经理
     * name : tuhui
     * openid : 000018
     * socketURL :
     * depname : 常青店
     * accode : .
     */
    private String topurl;
    private String erpname;
    private String openname;
    private String sn;
    private String invname;
    private String partialSn;
    private String compid;
    private String tallyflag;
    private String powerids;
    private String code;
    private String sessionid;
    private String id;
    private String invid;
    private String epid;
    private String rolename;
    private String name;
    private String openid;
    private String socketURL;
    private String depname;
    private String accode;
    private String branchId;
    private String serverCode;

    /**
     * "2表示经典版，5表示面料版，6表示零售版,7童装"
     */
    private String protype;

    private String must_reset_password;
    private String userEmbGuid;
    private String deviceEmbGuid;


    /**
     * G2 代表二代的接口
     * @return
     */
    public String getServerCode() {
        return serverCode;
    }

    public void setServerCode(String serverCode) {
        this.serverCode = serverCode;
    }

    public String getBranchId() {
        if (TextUtils.isEmpty(branchId)) {
            return "";
        }
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getMust_reset_password() {
        return must_reset_password;
    }

    public void setMust_reset_password(String must_reset_password) {
        this.must_reset_password = must_reset_password;
    }

    public String getUserEmbGuid() {
        return userEmbGuid;
    }

    public void setUserEmbGuid(String userEmbGuid) {
        this.userEmbGuid = userEmbGuid;
    }

    public String getDeviceEmbGuid() {
        return deviceEmbGuid;
    }

    public void setDeviceEmbGuid(String deviceEmbGuid) {
        this.deviceEmbGuid = deviceEmbGuid;
    }

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype;
    }

    public String getTopurl() {
        return topurl;
    }

    public void setTopurl(String topurl) {
        this.topurl = topurl;
    }

    public String getErpname() {
        return erpname;
    }

    public void setErpname(String erpname) {
        this.erpname = erpname;
    }

    public String getOpenname() {
        return openname;
    }

    public void setOpenname(String openname) {
        this.openname = openname;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getInvname() {
        return invname;
    }

    public void setInvname(String invname) {
        this.invname = invname;
    }

    public String getPartialSn() {
        return partialSn;
    }

    public void setPartialSn(String partialSn) {
        this.partialSn = partialSn;
    }

    public String getCompid() {
        return compid;
    }

    public void setCompid(String compid) {
        this.compid = compid;
    }

    public String getTallyflag() {
        return tallyflag;
    }

    public void setTallyflag(String tallyflag) {
        this.tallyflag = tallyflag;
    }

    public String getPowerids() {
        return powerids;
    }

    public void setPowerids(String powerids) {
        this.powerids = powerids;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvid() {
        return invid;
    }

    public void setInvid(String invid) {
        this.invid = invid;
    }

    public String getEpid() {
        if (TextUtils.isEmpty(epid)) {
            return "";
        }
        return epid;
    }

    public void setEpid(String epid) {
        this.epid = epid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSocketURL() {
        return socketURL;
    }

    public void setSocketURL(String socketURL) {
        this.socketURL = socketURL;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getAccode() {
        return accode;
    }

    public void setAccode(String accode) {
        this.accode = accode;
    }


    @Override
    public String toString() {
        return "SlhUserInfoBean{" +
                "topurl='" + topurl + '\'' +
                ", erpname='" + erpname + '\'' +
                ", openname='" + openname + '\'' +
                ", sn='" + sn + '\'' +
                ", invname='" + invname + '\'' +
                ", partialSn='" + partialSn + '\'' +
                ", compid='" + compid + '\'' +
                ", tallyflag='" + tallyflag + '\'' +
                ", powerids='" + powerids + '\'' +
                ", code='" + code + '\'' +
                ", sessionid='" + sessionid + '\'' +
                ", id='" + id + '\'' +
                ", invid='" + invid + '\'' +
                ", epid='" + epid + '\'' +
                ", rolename='" + rolename + '\'' +
                ", name='" + name + '\'' +
                ", openid='" + openid + '\'' +
                ", socketURL='" + socketURL + '\'' +
                ", depname='" + depname + '\'' +
                ", accode='" + accode + '\'' +
                ", branchId='" + branchId + '\'' +
                ", protype='" + protype + '\'' +
                ", must_reset_password='" + must_reset_password + '\'' +
                ", userEmbGuid='" + userEmbGuid + '\'' +
                ", deviceEmbGuid='" + deviceEmbGuid + '\'' +
                '}';
    }

    public List<String> getPowerList() {
        return SpliteStringUtils.getStringList(",", getPowerids());
    }
}
