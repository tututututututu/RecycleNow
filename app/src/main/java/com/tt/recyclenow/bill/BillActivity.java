package com.tt.recyclenow.bill;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hzecool.app.bean.app.ARouterUrl;
import com.hzecool.common.utils.DeviceUtils;
import com.hzecool.core.base.TBaseActivity;
import com.hzecool.widget.materialdialog.MaterialDialog;
import com.tt.recyclenow.R;
import com.tt.recyclenow.app.ServerUrls;
import com.tt.recyclenow.bean.BankBean;
import com.tt.recyclenow.bean.RecycleBean;

import butterknife.BindView;

/**
 * @author tutu
 * @time 2018/6/8
 */

public class BillActivity extends TBaseActivity<IBillView, BillPresenter>
        implements IBillView {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_pay_money)
    TextView tvPayMoney;
    @BindView(R.id.tv_send_money)
    TextView tvSendMoney;
    @BindView(R.id.tv_account)
    TextView tvAccount;
    @BindView(R.id.ll_info)
    LinearLayout llInfo;
    @BindView(R.id.cb)
    CheckBox cb;
    @BindView(R.id.tv_promise)
    TextView tvPromise;
    @BindView(R.id.ll_check)
    LinearLayout llCheck;
    @BindView(R.id.tv_next)
    CheckedTextView tvNext;
    @BindView(R.id.tv_day)
    TextView tvDay;
    @BindView(R.id.tv_huigou_pay)
    TextView tvHuiGou;

    private RecycleBean.DataBean recycleItem;
    private BankBean.DataBean bankBean;

    @Override
    public void onLoadData(Object o) {
        bankBean = (BankBean.DataBean) o;
        tvAccount.setText(bankBean.getBankname());
    }

    @Override
    public void onEmptyData() {

    }

    @Override
    public void onLoadError(String msg) {
        showAlertDlg("提示", msg);
    }

    @Override
    public void onNetError(String msg) {

    }

    @Override
    public int getLayoutID() {
        return R.layout.bill_activity;
    }

    @Override
    public void initView() {
        recycleItem = getIntent().getParcelableExtra("item");
        if (recycleItem != null) {
            tvName.setText(recycleItem.getTitle());
            tvPhone.setText(DeviceUtils.getModel());
            tvPayMoney.setText(recycleItem.getDqzj() + "元");
            tvPrice.setText(recycleItem.getHsze() + "元");
            tvSendMoney.setText(recycleItem.getDzje() + "元");
            tvTime.setText(recycleItem.getTs() + "天");
            tvDay.setText(recycleItem.getTs());
            tvHuiGou.setText(recycleItem.getHgze());
        }

        cb.setOnCheckedChangeListener((compoundButton, b) -> tvNext.setChecked(b));

        tvNext.setOnClickListener(view -> {
            if (tvNext.isChecked()) {
                mPresenter.order(String.valueOf(recycleItem.getId()), DeviceUtils.getModel(), DeviceUtils.getTotalInternalMemorySize());
            }
        });

        tvPromise.setOnClickListener(view -> new MaterialDialog.Builder(BillActivity.this)
                .title("协议")
                .items("回购协议", "回收协议")
                .itemsCallback((dialog, view1, which, text) -> {
                    if (which == 0) {
                        ARouter.getInstance().build(ARouterUrl.AR_URL_WEB_VIEW)
                                .withString("url", ServerUrls.ROUTER + "app/huigouxieyi.htm" + "?xh=" +
                                        DeviceUtils.getModel() + "&nc=" + DeviceUtils.getTotalInternalMemorySize())
                                .withString("title", "回购协议")
                                .navigation(BillActivity.this);
                    } else {
                        ARouter.getInstance().build(ARouterUrl.AR_URL_WEB_VIEW)
                                .withString("url", ServerUrls.ROUTER + "app/huishouxieyi.htm" + "?xh=" +
                                        DeviceUtils.getModel() + "&nc=" + DeviceUtils.getTotalInternalMemorySize())
                                .withString("title", "回收协议")
                                .navigation(BillActivity.this);
                    }

                })
                .show());
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("订单确认");
    }

    @Override
    protected BillPresenter createPresenter() {
        return new BillPresenter();
    }

    @Override
    public void orderOk(String msg) {
        showAlertDlg("提示", msg);
    }
}
