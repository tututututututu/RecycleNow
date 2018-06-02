package com.hzecool.core.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.hzecool.app.data.AppData;
import com.hzecool.common.utils.KeyboardUtils;
import com.hzecool.core.manager.ActivityStack;


/**
 * abstract activity管理activity出栈入栈
 *
 * @author tutu
 */
public abstract class TAbsActivity extends AppCompatActivity {
    //屏蔽home建标志
    public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);
        ActivityStack.push(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * 隐蔽软键盘
     */
    public void hideKeyBoard() {
        KeyboardUtils.hideSoftInput(this);
    }

    /**
     * 显示软键盘
     */
    public void showKeyBoard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.SHOW_FORCED);
        }
    }


    @Override
    protected void onDestroy() {
        hideKeyBoard();
        ActivityStack.pop(this);
        super.onDestroy();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 实现功能 点击空白区域隐藏软键盘
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
     */

    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_HOME) {
            if (AppData.productType() == AppData.PRODUCT_TYPE_WAREHOUSE_ASSISTANT) {
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
