package com.hzecool.app.data;

import com.hzecool.app.bean.user.SlhUserInfoBean;
import com.hzecool.app.bean.user.UserInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tutu
 * @time 2018/1/26
 * 用户信息
 */

public class UserData {
    /**
     * 用户手机号
     */
    public static String USER_PHONE = "";

    /**
     * 用户信息
     */
    public static UserInfoBean USER_INFO = new UserInfoBean();

    /**
     * 商陆花用户信息
     */
    public static SlhUserInfoBean SLH_USER_INFO = new SlhUserInfoBean();

    public static List<String> USER_POWER_LIST = new ArrayList<>();

    /**
     * uuid
     */
    public static String uuid = "";

    /**
     * 密码
     */
    public static String pass = "";
    /**
     * 工号
     */
    public static String code = "";
    /**
     * 账套id
     */
    public static String epid = "";

    /**
     * sessionid
     */
    public static String sessionid = "";
}
