package com.hzecool.app.bean.event;

import java.util.Map;

/**
 * Created by wangzhiguo on 2017/4/19.
 */

public class SearchHeadEvent extends BaseEvent {

    private Map<String, String> map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
