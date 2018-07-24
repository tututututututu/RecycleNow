package com.tt.recyclenow.index;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.common.utils.AppUtils;
import com.hzecool.common.utils.DeviceUtils;
import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.common.utils.SPUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.base.TBaseActivity;
import com.hzecool.core.base.TBaseFragment;
import com.hzecool.widget.materialdialog.MaterialDialog;
import com.tt.recyclenow.R;
import com.tt.recyclenow.account.login.LoginActivity;
import com.tt.recyclenow.app.Constants;
import com.tt.recyclenow.bean.IndexBanner;
import com.tt.recyclenow.bean.PhonePriceBean;
import com.tt.recyclenow.check.finish.CheckingResultActivity;
import com.tt.recyclenow.svc.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

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
    @BindView(R.id.banner)
    Banner banner;

    private PhonePriceBean phonePriceBean;

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


        String module = DeviceUtils.getModel();
        String memory = DeviceUtils.getTotalInternalMemorySize();
        tvModel.setText(TextUtils.isEmpty(module) ? "型号:" + "未知" : "型号:" + module);
        tvStore.setText(TextUtils.isEmpty(memory) ? "内存:" + "未知" : "内存:" + memory + "G");

        if (TextUtils.isEmpty(module) || TextUtils.isEmpty(memory)) {
            tvPrice.setText("不支持回收");
        } else {
            //mPresenter.getPhonePrice("iphone 6", "16");
            mPresenter.getPhonePrice(DeviceUtils.getModel(), DeviceUtils.getTotalInternalMemorySize());
        }
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        llBack.setVisibility(View.GONE);
        titleName.setText(AppUtils.getAppName(getActivity().getApplicationContext()));
    }

    @Override
    protected IndexPresenter createPresenter() {
        return new IndexPresenter();
    }


    @OnClick({R.id.tv_sale, R.id.tv_sale1})
    public void onClick(View view) {

        String tokens = SPUtils.getString(Constants.SP_TOKENDS);
        if (TextUtils.isEmpty(tokens)) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
            ToastUtils.showShortToast("请先登录");
            return;
        }

        if (phonePriceBean == null || null == phonePriceBean.getData()) {
            ((TBaseActivity) getActivity()).showAlertDlg("提示", phonePriceBean.getMsg());
            return;
        }

        Intent intent = new Intent(getActivity(), CheckingResultActivity.class);
        intent.putExtra("price", phonePriceBean.getData().getHsprice());

        switch (view.getId()) {
            case R.id.tv_sale:
            case R.id.tv_sale1:
                if ("1".equals(this.phonePriceBean.getData().getMark())) {
                    new MaterialDialog.Builder(getActivity())
                            .title("提示")
                            .content("系统正在升级维护")
                            .positiveText(ResourceUtils.getString(R.string.confirm))
                            .show();
                    return;
                } else {
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void BannerOk(IndexBanner indexBanner) {

        List<String> imageArray = new ArrayList<>();
        List<String> tt = new ArrayList<>();

        for (IndexBanner.DataBean dataBean : indexBanner.getData()) {
            imageArray.add(dataBean.getImg());
            tt.add("");
        }
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(imageArray);
        banner.setBannerTitles(tt);
        banner.setOnBannerListener(position -> {

        });


        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setDelayTime(3000);
        banner.start();
    }

    @Override
    public void PhonePriceOk(PhonePriceBean rep) {
        this.phonePriceBean = rep;
        tvPrice.setText(" ¥" + rep.getData().getPrice());
    }

    @Override
    public void PhonePriceFail(PhonePriceBean rep) {
        tvPrice.setText("不支持回收");
        tvSale.setEnabled(false);
        tvSale1.setEnabled(false);
        tvSale.setText("不支持回收");
    }


    //如果你需要考虑更好的体验，可以这么操作
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }

}

