package com.hzecool.app.bean.event;

import java.util.List;

/**
 * Created by song on 2017/8/10.
 */

public class BigPicEvent extends BaseEvent {
    private List<String> mArrayList;

    public BigPicEvent(List<String> arrayList) {
        mArrayList = arrayList;
    }

    public List<String> getArrayList() {
        return mArrayList;
    }

    public void setArrayList(List<String> arrayList) {
        mArrayList = arrayList;
    }
}
