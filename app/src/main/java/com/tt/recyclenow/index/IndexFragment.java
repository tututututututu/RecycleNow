package com.tt.recyclenow.index;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseFragment;
import com.tt.recyclenow.R;

/**
 * @author tutu
 * @time 2018/6/3
 */

public class IndexFragment extends TBaseFragment<IIndexView, IndexPresenter>
        implements IIndexView {
    @Override
    public void onLoadData(Object o) {

    }

    @Override
    public void onEmptyData() {

    }

    @Override
    public void onLoadError(String msg) {

    }

    @Override
    public void onNetError(String msg) {

    }

    @Override
    public int getLayoutID() {
        return R.layout.index_fragment_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        llBack.setVisibility(View.GONE);
        titleName.setText("即刻回收");
    }

    @Override
    protected IndexPresenter createPresenter() {
        return new IndexPresenter();
    }
}
