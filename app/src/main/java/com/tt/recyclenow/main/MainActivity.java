package com.tt.recyclenow.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.hzecool.core.base.TBaseActivity;
import com.tt.recyclenow.R;
import com.tt.recyclenow.index.IndexFragment;

import butterknife.BindView;

/**
 * @author tu
 */
public class MainActivity extends TBaseActivity<IMainView, MainPresenter>
        implements IMainView, BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;


    private IndexFragment indexFragment = new IndexFragment();
    private IndexFragment myFragment = new IndexFragment();

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        bottomNavigationBar.setTabSelectedListener(this);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.home_nome, "首页").setActiveColorResource(R.color.main))
                .addItem(new BottomNavigationItem(R.mipmap.my_nome, "我的").setActiveColorResource(R.color.main))
                .setFirstSelectedPosition(0)
                .initialise();

        changeFragment(0);
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
        changeFragment(position);
    }


    private void changeFragment(int position) {
        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, indexFragment).commitAllowingStateLoss();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, myFragment).commitAllowingStateLoss();
                break;
            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_frag_container, indexFragment).commitAllowingStateLoss();
                break;
        }
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
