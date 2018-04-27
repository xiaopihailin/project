package com.example.godlight.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.example.godlight.R;
import com.example.godlight.utils.StatusBarUtil;
import com.example.godlight.view.SystemBarTintManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static com.example.godlight.utils.StatusBarUtil.FlymeSetStatusBarLightMode;
import static com.example.godlight.utils.StatusBarUtil.MIUISetStatusBarLightMode;


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

        //transparencyBar(this);
        //StatusBarLightMode(this);

        //processMIUI(true);
        //setStatusBarColor(R.color.blackbbb);
        //StatusBarCompat.setStatusBarColor(this, Color.BLUE, false);
        //StatusBarUtil.setStatusBarLightMode(getWindow());
        //SystemUtil.setMeizuStatusBarDarkIcon(this,true);
    }


    /**
     *设置状态栏黑色字体图标，
     * 适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android
     * @param activity
     * @return 1:MIUUI 2:Flyme 3:android6.0
     */
    public static int StatusBarLightMode(Activity activity){
        int result=0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if(MIUISetStatusBarLightMode(activity.getWindow(), true)){
                result=1;
            }else if(FlymeSetStatusBarLightMode(activity.getWindow(), true)){
                result=2;
            }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                result=3;
            }
        }
        return result;
    }







    //透明状态栏
    @TargetApi(19)
    public static void transparencyBar(Activity activity){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);

        } else
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window =activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
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

    private void processMIUI(boolean lightStatusBar) {

        Class<? extends Window> clazz = getWindow().getClass();

        try {

            int darkModeFlag;

            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");

            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");

            darkModeFlag = field.getInt(layoutParams);

            Method extraFlagField = clazz.getMethod("setExtraFlags",int.class,int.class);

            extraFlagField.invoke(getWindow(), lightStatusBar? darkModeFlag : 0, darkModeFlag);

        } catch (Exception ignored) {



        }

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
