package com.example.godlight.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.example.godlight.R;
import com.example.godlight.view.SystemBarTintManager;


/**
 * Created by Lzh on 2018/4/20.
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadView();
        initView();
        initData();
        progress();
        setAllEvent();
        setStatusBarColor(R.color.colorPrimaryDark);

    }


    public void setStatusBarColor(int colorID) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setStatusBarColorLOLLIPOP(colorID);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setNavigationBarTintEnabled(true);
            tintManager.setStatusBarTintColor(getResources().getColor(colorID));
        }
    }

    @TargetApi(21)
    private void setStatusBarColorLOLLIPOP(int colorID) {
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(colorID));
        window.setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    protected abstract void loadView();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void setAllEvent();
    protected abstract void progress();


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        this.overridePendingTransition(R.anim.default_anim,
                R.anim.right_out);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        Activity act=this;
        while (act.getParent()!=null) {
            act=act.getParent();
        }
        act.overridePendingTransition(R.anim.right_in,R.anim.default_anim);
    }

    @Override
    public void finish() {
        super.finish();
        Activity act=this;
        while (act.getParent()!=null) {
            act=act.getParent();
        }
        act.overridePendingTransition(R.anim.default_anim,
                R.anim.right_out);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.right_in,R.anim.default_anim);
    }


    /**
     * 点击空白处软键盘消失
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (this.getCurrentFocus() != null) { // 点击非输入区域关闭软键盘
                if (this.getCurrentFocus().getWindowToken() != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    return imm.hideSoftInputFromWindow(this.getCurrentFocus()
                            .getWindowToken(), 0);
                }
            }
        }
        return super.onTouchEvent(event);
    }


}
