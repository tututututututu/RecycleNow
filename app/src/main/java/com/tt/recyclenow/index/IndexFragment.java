package com.tt.recyclenow.index;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseFragment;
import com.tt.recyclenow.R;
import com.tt.recyclenow.check.CheckPhoneActivity;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author tutu
 * @time 2018/6/3
 */

public class IndexFragment extends TBaseFragment<IIndexView, IndexPresenter>
        implements IIndexView {
    @BindView(R.id.tv_model)
    TextView tvModel;
    @BindView(R.id.tv_store)
    TextView tvStore;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_sale1)
    TextView tvSale1;
    @BindView(R.id.tv_sale)
    TextView tvSale;
    Unbinder unbinder;

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


    @OnClick({R.id.tv_sale})
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), CheckPhoneActivity.class);

        switch (view.getId()) {
            case R.id.tv_sale:
            case R.id.tv_sale1:
                startActivity(intent);
                break;
        }
    }
}

