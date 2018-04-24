package com.example.godlight.ui.account;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.godlight.R;
import com.example.godlight.base.BaseActivity;
import com.example.godlight.base.BaseApplication;
import com.example.godlight.view.ClearEditText;
import java.lang.reflect.Method;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity {

    private final String mPageName = "LoginActivity";
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.ll_title)
    RelativeLayout llTitle;
    @Bind(R.id.iv_logo)
    ImageView ivLogo;
    @Bind(R.id.iv_account)
    ImageView ivAccount;
    @Bind(R.id.et_account)
    ClearEditText etAccount;
    @Bind(R.id.view_account)
    View viewAccount;
    @Bind(R.id.rl_account)
    RelativeLayout rlAccount;
    @Bind(R.id.iv_pwd)
    ImageView ivPwd;
    @Bind(R.id.et_login_pwd)
    ClearEditText etLoginPwd;
    @Bind(R.id.view_pwd)
    View viewPwd;
    @Bind(R.id.rl_pwd)
    RelativeLayout rlPwd;
    @Bind(R.id.btn_login)
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStatusBarColor(R.color.white);

    }

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        BaseApplication.getInstance().addActivity(this);

    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void setAllEvent() {

    }

    @Override
    protected void progress() {

    }


    public static boolean checkPermission(Context context, String permission) {
        boolean result = false;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Class<?> clazz = Class.forName("android.content.Context");
                Method method = clazz.getMethod("checkSelfPermission", String.class);
                int rest = (Integer) method.invoke(context, permission);
                if (rest == PackageManager.PERMISSION_GRANTED) {
                    result = true;
                } else {
                    result = false;
                }
            } catch (Exception e) {
                result = false;
            }
        } else {
            PackageManager pm = context.getPackageManager();
            if (pm.checkPermission(permission, context.getPackageName()) == PackageManager.PERMISSION_GRANTED) {
                result = true;
            }
        }
        return result;
    }

    @OnClick({R.id.tv_right, R.id.et_account, R.id.et_login_pwd, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_right:
                Intent intent =new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.et_account:
                break;
            case R.id.et_login_pwd:
                break;
            case R.id.btn_login:
                break;
        }
    }
}
