package com.hzecool.core.phone;

import java.util.List;

/**
 * Created by wangzhiguo on 2017/8/9
 */
public interface IPhone {
    void call(String phoneNumber, IPhoneCallBack callBack);
    void sendMessage(List<String> phoneNumbers, String content, IPhoneCallBack callBack);
}
