package com.tt.recyclenow.mine.guide;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;
import com.tt.recyclenow.bean.HelpBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by tu on 2018/7/24.
 */

public class HelpActivity extends TBaseActivity<IHelpView, HelpPresenter>
        implements IHelpView {
    @BindView(R.id.rv)
    RecyclerView rv;

    private HelpAdapter helpAdapter;

    @Override
    public void onLoadData(Object o) {
        List<HelpBean.DataBean> data = (List<HelpBean.DataBean>) o;
        List<String> dataShow = new ArrayList<>();
        for (HelpBean.DataBean datum : data) {
            dataShow.add(datum.getTitle());
            dataShow.add(datum.getCont());
        }

        helpAdapter.setNewData(dataShow);
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
        return R.layout.help_activity;
    }

    @Override
    public void initView() {
        helpAdapter = new HelpAdapter(null);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(helpAdapter);
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("常见问题");
    }

    @Override
    protected HelpPresenter createPresenter() {
        return new HelpPresenter();
    }
}
