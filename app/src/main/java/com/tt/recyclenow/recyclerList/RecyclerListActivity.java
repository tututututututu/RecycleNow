package com.tt.recyclenow.recyclerList;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;

import butterknife.BindView;

/**
 * @author tutu
 * @time 2018/6/8
 */

public class RecyclerListActivity extends TBaseActivity<IRecyclerListView, RecyclerListPresenter>
        implements IRecyclerListView {
    @BindView(R.id.rv)
    RecyclerView rv;


    private RecyclerListAdapter adapter;

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
        return R.layout.recycler_list_layout;
    }

    @Override
    public void initView() {
        adapter = new RecyclerListAdapter(null);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected RecyclerListPresenter createPresenter() {
        return new RecyclerListPresenter();
    }


}
