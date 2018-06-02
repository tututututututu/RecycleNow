package com.tt.recyclenow.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;

import butterknife.BindView;

/**
 * @author tu
 */
public class MainActivity extends TBaseActivity<IMainView, MainPresenter>
        implements IMainView,BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        bottomNavigationBar.setTabSelectedListener(this);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_empty_zhihu, "Home").setActiveColorResource(R.color.base_black))
                .addItem(new BottomNavigationItem(R.drawable.ic_empty_zhihu, "Books").setActiveColorResource(R.color.base_white))
                .setFirstSelectedPosition(0)
                .initialise();
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onTabSelected(int position) {

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

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
}
