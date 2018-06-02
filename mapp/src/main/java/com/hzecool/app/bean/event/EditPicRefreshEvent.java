package com.hzecool.app.bean.event;

import java.util.ArrayList;

/**
 *
 * @author song
 * @date 2017/8/10
 */

public class EditPicRefreshEvent extends BaseEvent {
    private ArrayList<String> mArrayList;

    public EditPicRefreshEvent(ArrayList<String> arrayList) {
        mArrayList = arrayList;
    }

    public ArrayList<String> getArrayList() {
        return mArrayList;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        mArrayList = arrayList;
    }
}
