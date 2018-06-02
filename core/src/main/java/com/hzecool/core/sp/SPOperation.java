package com.hzecool.core.sp;


import android.text.TextUtils;

import com.hzecool.app.bean.user.SlhUserInfoBean;
import com.hzecool.app.bean.user.UserInfoBean;
import com.hzecool.app.data.AppConstant;
import com.hzecool.app.data.ParamConstant;
import com.hzecool.common.json.GsonUtils;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.log.L;

import java.util.UUID;

import static com.hzecool.common.utils.SPUtils.getString;

/**
 * SP常用操作
 *
 * @author tutu
 * @date 2017/3/6
 */

public class SPOperation {
    /**
     * 取用户信息
     *
     * @return UserInfoBean
     */
    public static UserInfoBean getUserInfo() {
        String jsonStr = getString(AppConstant.USER_INFO);
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }

        return GsonUtils.jsonToObj(jsonStr, UserInfoBean.class);
    }

    /**
     * 保存用户信息
     */
    public static void saveUserInfo(SlhUserInfoBean usersave) {
        if (usersave == null) {
            L.e("SP保存的用户信息为空");
        } else {
            SPUtils.putString(AppConstant.SLH_USER_INFO, GsonUtils.object2Json(usersave));
        }
    }

    public static void saveOATestList(String s) {
        SPUtils.putString("OATestList", s);
    }

    public static String getOATestList() {
        return SPUtils.getString("OATestList");
    }

    /**
     * 设置是否启用了ssl
     */
    public static void saveEnableSsl(boolean enable) {
        SPUtils.putBoolean("ssl", enable);
    }

    /**
     * 是否启用了ssl
     */
    /**
     * 设置是否启用了ssl
     */
    public static boolean enableSsl() {
        return SPUtils.getBoolean("ssl", false);
    }

    /**
     * 保存商陆花用户信息
     */
    public static void saveSlhUserInfo(SlhUserInfoBean usersave) {
        if (usersave == null) {
            L.logFile("用户信息 SP保存的用户信息为空");
        } else {
            String json = GsonUtils.object2Json(usersave);
            SPUtils.putString(AppConstant.SLH_USER_INFO, json);
            L.logFile("用户信息 SP保存的用户信息成功:" + json);
        }
    }

    /**
     * 获取商陆花用户信息
     */
    public static SlhUserInfoBean getSlhUserInfo() {

        try {
            String jsonStr = getString(AppConstant.SLH_USER_INFO);
            if (TextUtils.isEmpty(jsonStr)) {
                L.logFile("用户信息 从sp读取SLH_USER_INFO 失败 jsonStr为空");
                return null;
            }

            return GsonUtils.jsonToObj(jsonStr, SlhUserInfoBean.class);

        } catch (Exception e) {
            L.logFile("用户信息 从sp读取SLH_USER_INFO 失败 " + e.getMessage());
            return null;
        }
    }

    /**
     * 单独保存手机号，重新登录用
     */
    public static void saveUserMobile(String mobile) {
        SPUtils.putString(AppConstant.USER_MOBILE, mobile);
    }

    /**
     * 取得手机号，重新登录用
     */
    public static String getUserMobile() {
        return getString(AppConstant.USER_MOBILE);
    }

    /**
     * 只清除用户数据
     */
    public static void clearUserInfo() {
        SPUtils.remove(AppConstant.SLH_USER_INFO);
        SPUtils.remove(ParamConstant.SESSIONID);
    }

    /**
     * 清除所有的sp数据
     */
    public static void clearSp() {
        SPUtils.clear();
    }

    /**
     * 保存sessionid
     */
    public static void saveSessionId(String sessionId) {
        SPUtils.putString(ParamConstant.SESSIONID, sessionId);
    }

    /**
     * 获取sessionid
     */
    public static String getSessionId() {
        return SPUtils.getString(ParamConstant.SESSIONID);
    }


    /**
     * 存UUID
     */
    public static void saveUUID(String uuid) {
        SPUtils.putString(ParamConstant.UUID, uuid);
    }


    /**
     * 获取uuid
     */
    public static String getUUID() {

        String uuid = SPUtils.getString(ParamConstant.UUID);
        if (TextUtils.isEmpty(uuid)) {
            uuid = UUID.randomUUID().toString();
        }

        return uuid;
    }

    /**
     * 获取款式最后一次同步数据同步时间
     */
    public static String getLastSynDataTimeDress() {
        return SPUtils.getString(AppConstant.SYNDATA_LAST_TIME_DRESS_STYLE, "");
    }

    /**
     * 款式详情
     *
     * @return
     */
    public static String getLastSyncDataTimeDressStyleDetail() {
        return SPUtils.getString(AppConstant.SYNDATA_LAST_TIME_DRESS_STYLE_DETAIL, "");
    }

    public static void saveLastSyncDataTimeDressStyleDetail(String time) {
        SPUtils.putString(AppConstant.SYNDATA_LAST_TIME_DRESS_STYLE_DETAIL, time);
    }

    /**
     * 保存款式最后一次同步数据同步时间
     */
    public static void saveLastSynDataTimeDress(String time) {
        SPUtils.putString(AppConstant.SYNDATA_LAST_TIME_DRESS_STYLE, time);
    }

    /**
     * 获取语音语义信息的最后一次同步信息
     *
     * @return
     */
    public static String getLastSynDataTimeVoice() {
        return SPUtils.getString(AppConstant.SYNDATA_LAST_TIME_VOICE, "");
    }

    /**
     * 保存语音语义信息的最后一次同步信息
     */
    public static void saveLastSynDataTimeVoice(String time) {
        SPUtils.putString(AppConstant.SYNDATA_LAST_TIME_VOICE, time);
    }


    /**
     * 获取店员的最后一次同步信息
     *
     * @return
     */
    public static String getLastSynDataTimeStaff() {
        return SPUtils.getString(AppConstant.SYNDATA_LAST_TIME_STAFF, "");
    }

    /**
     * 保存店员最后一次同步信息
     */
    public static void saveLastSynDataTimeStaff(String time) {
        SPUtils.putString(AppConstant.SYNDATA_LAST_TIME_STAFF, time);
    }

    /**
     * 获取往来单位最后一次同步数据同步时间
     */
    public static String getLastSynDataTimeDWXX() {
        return SPUtils.getString(AppConstant.SYNDATA_LAST_TIME_DWXX, "");
    }

    /**
     * 保存往来单位最后一次同步数据同步时间
     */
    public static void saveLastSynDataTimeDWXX(String time) {
        SPUtils.putString(AppConstant.SYNDATA_LAST_TIME_DWXX, time);
    }


    /**
     * 获取颜色最后一次同步数据同步时间
     */
    public static String getLastSynDataTimeColor() {
        return SPUtils.getString(AppConstant.SYNDATA_LAST_TIME_COLOR, "");
    }

    /**
     * 保存颜色最后一次同步数据同步时间
     */
    public static void saveLastSynDataTimeColor(String time) {
        SPUtils.putString(AppConstant.SYNDATA_LAST_TIME_COLOR, time);
    }

    /**
     * 获取尺寸最后一次同步数据同步时间
     */
    public static String getLastSynDataTimeSize() {
        return SPUtils.getString(AppConstant.SYNDATA_LAST_TIME_SIZE, "");
    }

    /**
     * 保存尺寸最后一次同步数据同步时间
     */
    public static void saveLastSynDataTimeSize(String time) {
        SPUtils.putString(AppConstant.SYNDATA_LAST_TIME_SIZE, time);
    }

    /**
     * 获取品牌最后一次同步数据同步时间
     */
    public static String getLastSynDataTimeBrand() {
        return SPUtils.getString(AppConstant.SYNDATA_LAST_TIME_BRAND, "");
    }

    /**
     * 保存品牌最后一次同步数据同步时间
     */
    public static void saveLastSynDataTimeBrand(String time) {
        SPUtils.putString(AppConstant.SYNDATA_LAST_TIME_BRAND, time);
    }

    /**
     * 获取类别最后一次同步数据同步时间
     */
    public static String getLastSynDataTimeClass() {
        return SPUtils.getString(AppConstant.SYNDATA_LAST_TIME_CLASS, "");
    }

    /**
     * 保存类别最后一次同步数据同步时间
     */
    public static void saveLastSynDataTimeClass(String time) {
        SPUtils.putString(AppConstant.SYNDATA_LAST_TIME_CLASS, time);
    }

    /**
     * 获取颜色组最后一次同步数据同步时间
     */
    public static String getLastSynDataTimeColorGroup() {
        return SPUtils.getString(AppConstant.SYNDATA_LAST_TIME_COLOR_GROUP, "");
    }

    /**
     * 保存颜色组最后一次同步数据同步时间
     */
    public static void saveLastSynDataTimeColorGroup(String time) {
        SPUtils.putString(AppConstant.SYNDATA_LAST_TIME_COLOR_GROUP, time);
    }

    /**
     * 获取尺码组最后一次同步数据同步时间
     */
    public static String getLastSynDataTimeSizeGroup() {
        return SPUtils.getString(AppConstant.SYNDATA_LAST_TIME_SIZE_GROUP, "");
    }

    /**
     * 保存尺码组最后一次同步数据同步时间
     */
    public static void saveLastSynDataTimeSizeGroup(String time) {
        SPUtils.putString(AppConstant.SYNDATA_LAST_TIME_SIZE_GROUP, time);
    }

    /**
     * 保存系统参数配置
     */
    public static void saveSysConfig(String config) {
        SPUtils.putString(AppConstant.SYS_CONFIG, config);
    }


    /**
     * 保存系统参数配置
     */
    public static String getSysConfig() {
        return SPUtils.getString(AppConstant.SYS_CONFIG);
    }

    /**
     * 清除指定类型数据缓存时间
     * 0清理全部
     */
    public static void clearSyncTime(String type) {
        switch (type) {
            case AppConstant.SYNDATA_LAST_TIME_DRESS_STYLE:
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_DRESS_STYLE);
                break;
            case AppConstant.SYNDATA_LAST_TIME_DWXX:
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_DWXX);
                break;
            case AppConstant.SYNDATA_LAST_TIME_COLOR:
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_COLOR);
                break;
            case AppConstant.SYNDATA_LAST_TIME_SIZE:
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_SIZE);
                break;
            case AppConstant.SYNDATA_LAST_TIME_VOICE:
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_VOICE);
            case "0":
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_DRESS_STYLE);
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_DWXX);
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_SIZE);
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_COLOR);
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_VOICE);

                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_BRAND);
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_CLASS);

                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_COLOR_GROUP);
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_SIZE_GROUP);
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_DRESS_STYLE_DETAIL);
                SPUtils.remove(AppConstant.SYNDATA_LAST_TIME_STAFF);
                break;
            default:
                break;
        }
    }

}
