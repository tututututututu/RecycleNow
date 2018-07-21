package com.tt.recyclenow.auth.person;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hzecool.common.utils.Utils;
import com.hzecool.core.base.TBaseActivity;
import com.hzecool.widget.materialdialog.MaterialDialog;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.tt.recyclenow.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tu on 2018/7/18.
 */

public class PersonInfoAuthActivity extends TBaseActivity<IPersonInfoAuth, PersonInfoAuthPresenter>
        implements IPersonInfoAuth {
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.rl1)
    RelativeLayout rl1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.et2)
    EditText et2;
    @BindView(R.id.rl2)
    RelativeLayout rl2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.et3)
    EditText et3;
    @BindView(R.id.rl3)
    RelativeLayout rl3;
    @BindView(R.id.et4)
    EditText et4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.et5)
    EditText et5;
    @BindView(R.id.rl5)
    RelativeLayout rl5;
    @BindView(R.id.tv6)
    TextView tv6;
    @BindView(R.id.iv6)
    ImageView iv6;
    @BindView(R.id.et6)
    EditText et6;
    @BindView(R.id.rl6)
    RelativeLayout rl6;
    @BindView(R.id.tv7)
    TextView tv7;
    @BindView(R.id.et7)
    EditText et7;
    @BindView(R.id.tv8)
    TextView tv8;
    @BindView(R.id.et8)
    EditText et8;
    @BindView(R.id.tv9)
    TextView tv9;
    @BindView(R.id.iv9)
    ImageView iv9;
    @BindView(R.id.et9)
    EditText et9;
    @BindView(R.id.rl9)
    RelativeLayout rl9;
    @BindView(R.id.tv10)
    TextView tv10;
    @BindView(R.id.et10)
    EditText et10;
    @BindView(R.id.tv11)
    TextView tv11;
    @BindView(R.id.et11)
    EditText et11;
    @BindView(R.id.tv_finish)
    TextView tvFinish;


    CityPickerView mPicker = new CityPickerView();

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
        return R.layout.person_info_activity_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPicker.init(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected PersonInfoAuthPresenter createPresenter() {
        return new PersonInfoAuthPresenter();
    }


    @OnClick({R.id.rl1, R.id.rl2, R.id.rl3, R.id.rl5, R.id.rl6, R.id.rl9})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl1:
                zhufang();
                break;
            case R.id.rl2:
                wenhua();
                break;
            case R.id.rl3:
                dizhi();
                break;
            case R.id.rl5:
                juzhushichang();
                break;
            case R.id.rl6:
                lianxiren1guanxi();
                break;
            case R.id.rl9:
                lianxiren2guanxi();
                break;
            default:
                break;
        }
    }

    private void dizhi() {
        CityConfig cityConfig = new CityConfig.Builder().build();
        mPicker.setConfig(cityConfig);

        mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                //省份
                if (province != null) {

                }

                //城市
                if (city != null) {

                }

                //地区
                if (district != null) {

                }
            }

            @Override
            public void onCancel() {
            }
        });

        //显示
        mPicker.showCityPicker();
    }

    private void lianxiren2guanxi() {
        List<String> items = new ArrayList<>();
        items.add("同事");
        items.add("朋友");
        items.add("兄弟姐妹");
        new MaterialDialog.Builder(this)
                .title("第二联系人")
                .items(items)
                .itemsCallbackSingleChoice(-1, (dialog, view, which, text) -> {

                    return true;
                })
                .positiveText("确定")
                .show();
    }

    private void lianxiren1guanxi() {
        List<String> items = new ArrayList<>();
        items.add("父亲");
        items.add("母亲");
        items.add("配偶");
        items.add("子女");
        new MaterialDialog.Builder(this)
                .title("第一联系人")
                .items(items)
                .itemsCallbackSingleChoice(-1, (dialog, view, which, text) -> {

                    return true;
                })
                .positiveText("确定")
                .show();
    }

    private void juzhushichang() {
        List<String> items = new ArrayList<>();
        items.add("1-3个月");
        items.add("3-6个月");
        items.add("6-12个月");
        items.add("12-24个月");
        items.add("24个月以上");
        new MaterialDialog.Builder(this)
                .title("居住时长情况")
                .items(items)
                .itemsCallbackSingleChoice(-1, (dialog, view, which, text) -> {

                    return true;
                })
                .positiveText("确定")
                .show();
    }

    private void wenhua() {
        List<String> items = new ArrayList<>();
        items.add("小学");
        items.add("初中");
        items.add("高中");
        items.add("大专");
        items.add("本科");
        items.add("硕士");
        items.add("博士");
        new MaterialDialog.Builder(this)
                .title("学历情况")
                .items(items)
                .itemsCallbackSingleChoice(-1, (dialog, view, which, text) -> {

                    return true;
                })
                .positiveText("确定")
                .show();
    }

    private void zhufang() {
        List<String> items = new ArrayList<>();
        items.add("自购房未抵押");
        items.add("自购房已抵押");
        items.add("与父母同住但名下无房");
        items.add("租房");
        items.add("单位宿舍");
        items.add("其他");
        new MaterialDialog.Builder(this)
                .title("住房情况")
                .items(items)
                .itemsCallbackSingleChoice(-1, (dialog, view, which, text) -> {

                    return true;
                })
                .positiveText("确定")
                .show();
    }

    /**
     * 通讯录认证
     *
     * @param card
     */
    public void requestPermissionContact(final String card) {
        RxPermissions rxPermissions = new RxPermissions(this);

        rxPermissions.request(
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        mPresenter.getContacts();
                    } else {
                        Toast.makeText(Utils.getContext(), "没有获取到需要的权限", Toast.LENGTH_SHORT).show();

                    }
                });

    }
}
