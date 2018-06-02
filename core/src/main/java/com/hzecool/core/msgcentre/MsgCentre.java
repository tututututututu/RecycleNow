package com.hzecool.core.msgcentre;

import com.hzecool.core.log.L;
import com.hzecool.core.log.LocalLogManager;
import com.hzecool.core.msgcentre.bean.BaseMsgCentreEventBean;
import com.hzecool.core.msgcentre.bean.SynDataMsgEvent;
import com.hzecool.core.net.RxHelper;
import com.hzecool.core.rxbus.RxBus;

import java.util.concurrent.TimeUnit;

/**
 * 消息中转中心
 *
 * @author tutu
 * @date 2017/4/24
 */

public class MsgCentre {
    public static void registMsgCentre() {
        RxBus.obtainEvent(BaseMsgCentreEventBean.class)
                .throttleFirst(2000, TimeUnit.MILLISECONDS)
                .compose(RxHelper.switchSchedulers())
                .subscribe(msgCentreEventBean -> {
                    L.logFile("消息中心:" + msgCentreEventBean.toString());
                    /**
                     * 消息分类中转
                     */
                    switch (msgCentreEventBean.getMsgBean().getBizType()) {
                        //获取日志
                        case "100":
                            LocalLogManager.getInstanse().uploadLogByName(msgCentreEventBean.getMsgBean().getBody().getLog_date(), null);
                            break;
                        //同步数据
                        case "101":
                            SynDataMsgEvent synDataMsgEvent = new SynDataMsgEvent(msgCentreEventBean.getMsgBean().getBody().getVal());
                            RxBus.postEvent(synDataMsgEvent, SynDataMsgEvent.class);
                            break;
                        //商圈动态消息通知
                        case "102":
                            break;
                        //商圈你有新的关注请求
                        case "103":
                            break;
                        //消息中心消息
                        case "104":
                            break;
                        default:
                            break;
                    }

                });
    }
}
