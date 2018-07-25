package com.tt.recyclenow.auth.person;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hzecool.common.utils.ToastUtils;
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
import com.tt.recyclenow.auth.person.gps.LocationHelper;
import com.tt.recyclenow.bean.PersonAuthBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @BindView(R.id.et_qq)
    EditText etQQ;
    @BindView(R.id.et_wx)
    EditText etWX;

    CityPickerView mPicker = new CityPickerView();
    private LocationHelper locationHelper;

    private String sheng;
    private String shi;
    private String qu;

    @Override
    public void onLoadData(Object o) {
        ToastUtils.showShortToast("认证成功");
        finish();
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
        titleName.setText("个人信息");
    }

    @Override
    protected PersonInfoAuthPresenter createPresenter() {
        return new PersonInfoAuthPresenter();
    }

    @OnClick({R.id.rl1, R.id.et1, R.id.rl2, R.id.et2, R.id.rl3, R.id.et3, R.id.rl5,
            R.id.et5, R.id.rl6, R.id.et6, R.id.rl9, R.id.et9, R.id.tv_finish, R.id.rl8, R.id.rl11,
            R.id.et8,R.id.et11})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl1:
            case R.id.et1:
                zhufang();
                break;
            case R.id.rl2:
            case R.id.et2:
                wenhua();
                break;
            case R.id.rl3:
            case R.id.et3:
                dizhi();
                break;
            case R.id.rl5:
            case R.id.et5:
                juzhushichang();
                break;
            case R.id.rl6:
            case R.id.et6:
                lianxiren1guanxi();
                break;
            case R.id.rl9:
            case R.id.et9:
                lianxiren2guanxi();
                break;
            case R.id.tv_finish:
                mPresenter.upLoadData(wrapParams());
                break;
            case R.id.et8:
            case R.id.rl8:
                startActivityForResult(new Intent(
                        Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI), 1);
                break;
            case R.id.et11:
            case R.id.rl11:
                startActivityForResult(new Intent(
                        Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI), 2);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            ContentResolver reContentResolverol = getContentResolver();
            Uri contactData = data.getData();
            @SuppressWarnings("deprecation")
            Cursor cursor = managedQuery(contactData, null, null, null, null);
            cursor.moveToFirst();
            String username = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor phone = reContentResolverol.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId,
                    null,
                    null);
            while (phone.moveToNext()) {
                String usernumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                if (requestCode == 1) {
                    et8.setText(usernumber);
                } else if (requestCode == 2) {
                    et11.setText(usernumber);
                }
            }

        }
    }

    private Map<String, String> wrapParams() {

        Map<String, String> params = new HashMap<>();
        params.put("userEmail", etWX.getText().toString().trim());
        params.put("userQq", etQQ.getText().toString().trim());
        params.put("zn", et1.getText().toString().trim());
        params.put("xl", et2.getText().toString().trim());
        params.put("jh", et5.getText().toString().trim());
        params.put("bz1", sheng);
        params.put("bz2", shi);
        params.put("bz3", qu);
        params.put("userAddr", et4.getText().toString().trim());
        params.put("qsgx", et6.getText().toString().trim());
        params.put("gxname", et7.getText().toString().trim());
        params.put("qsgxtel", et8.getText().toString().trim());
        params.put("sjgx1", et9.getText().toString().trim());
        params.put("gxname1", et10.getText().toString().trim());
        params.put("sjgxtel1", et11.getText().toString().trim());
        return params;
    }

    private void dizhi() {
        CityConfig cityConfig = new CityConfig.Builder().build();
        mPicker.setConfig(cityConfig);

        mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {

                StringBuilder sb = new StringBuilder();
                //省份
                if (province != null) {
                    sb.append(province.getName());
                    sheng = province.getName();
                }

                //城市
                if (city != null) {
                    sb.append(city.getName());
                    shi = city.getName();
                }

                //地区
                if (district != null) {
                    sb.append(district.getName());
                    qu = district.getName();
                }

                et3.setText(sb.toString());
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
                    et9.setText(text);
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
                    et6.setText(text);
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
                    et5.setText(text);
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
                    et2.setText(text);
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
                    et1.setText(text);
                    return true;
                })
                .positiveText("确定")
                .show();
    }

    @Override
    public void requestPermision() {
        RxPermissions rxPermissions = new RxPermissions(this);

        rxPermissions.request(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_CONTACTS
        )
//                .subscribe()
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        locationHelper = new LocationHelper(getApplicationContext());
                        locationHelper.initLocation();
                        mPresenter.permissionOk();
                    } else {
                        Toast.makeText(Utils.getContext(), "没有获取到需要的权限", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void reFillData(PersonAuthBean rep) {
        PersonAuthBean.DataBean data = rep.getData();
        if (data != null) {
            et1.setText(data.getZn());
            et2.setText(data.getXl());
            et3.setText(data.getBz1() + data.getBz2() + data.getBz3());
            et4.setText(data.getUserAddr());
            et5.setText(data.getJh());
            et6.setText(data.getQsgx());
            et7.setText(data.getGxname());
            et8.setText(data.getQsgxtel());
            et9.setText(data.getSjgx1());
            et10.setText(data.getGxname1());
            et11.setText(data.getSjgxtel1());
            etQQ.setText(data.getUserQq());
            etWX.setText(data.getUserEmail());
            this.sheng = data.getBz1();
            this.shi = data.getBz2();
            this.qu = data.getBz3();
        }
    }
}
