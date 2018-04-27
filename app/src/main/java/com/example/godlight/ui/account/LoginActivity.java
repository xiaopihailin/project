package com.example.godlight.ui.account;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.godlight.R;
import com.example.godlight.base.BaseActivity;
import com.example.godlight.bean.LoginBean;
import com.example.godlight.smodel.LoginModel;
import com.example.godlight.spresenter.LoginPresenter;
import com.example.godlight.sview.LoginView;
import com.example.godlight.ui.MainActivity;
import com.githang.statusbar.StatusBarCompat;

import java.lang.reflect.Method;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity implements LoginView {

    private final String mPageName = "LoginActivity";
    @Bind(R.id.hulue)
    TextView hulue;
    @Bind(R.id.denglu)
    TextView denglu;
    @Bind(R.id.zhuce)
    TextView zhuce;
    @Bind(R.id.iv_logo)
    ImageView ivLogo;
    @Bind(R.id.imageview_shou)
    ImageView imageviewShou;
    @Bind(R.id.et_account)
    EditText etAccount;
    @Bind(R.id.view_account)
    View viewAccount;
    @Bind(R.id.rl_account)
    RelativeLayout rlAccount;
    @Bind(R.id.suo)
    ImageView suo;
    @Bind(R.id.et_login_pwd)
    EditText etLoginPwd;
    @Bind(R.id.view_pwd)
    View viewPwd;
    @Bind(R.id.rl_pwd)
    RelativeLayout rlPwd;
    @Bind(R.id.button_denglu)
    Button buttonDenglu;
    @Bind(R.id.btn_login)
    RelativeLayout btnLogin;
    @Bind(R.id.tv_backpsw)
    TextView tvBackpsw;
    @Bind(R.id.rl_backpsw)
    RelativeLayout rlBackpsw;


    private LoginPresenter presenter;
    private LoginModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setStatusBarColor(R.color.white);

    }

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_login);
        StatusBarCompat.setStatusBarColor(this, Color.BLUE, false);
        ButterKnife.bind(this);
        // BaseApplication.getInstance().addActivity(this);

    }

    @Override
    protected void initView() {
        presenter = new LoginPresenter(this);
        model = new LoginModel(this);

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



  /*  @OnClick({R.id.et_account, R.id.et_login_pwd, R.id.btn_login,R.id.zhuce})
     public void onViewClicked(View view) {
         switch (view.getId()) {
             case R.id.et_account:


                 break;
             case R.id.et_login_pwd:
                 break;
            *//**//**//**//* case R.id.shejiao:
                Toast.makeText(this, "shejiao", Toast.LENGTH_SHORT).show();


                break;*//**//**//**//*
            case R.id.btn_login:
                //Toast.makeText(this, "dainji", Toast.LENGTH_SHORT).show();
                String phone = etAccount.getText().toString();
                String pwd = etLoginPwd.getText().toString();
                presenter.SetLogin(phone, pwd);
                break;

            case R.id.zhuce:
                //Toast.makeText(this, "zhuce", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

        }
    }*/

    @Override
    public void Success(LoginBean bean) {
        Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
        //Log.i("nihao:",bean.getMsg());
        if(bean.getMsg().equals("登录成功！")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        }
    }

    @Override
    public void Failer(String s) {
        Toast.makeText(this, s + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void EmpatyPhone() {
        Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void EmpatyPwd() {
        Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.button_denglu,R.id.tv_backpsw,R.id.zhuce})
    public void onViewClicked(View view) {


        switch (view.getId()) {
            case R.id.button_denglu:
                String phone = etAccount.getText().toString();
                String pwd = etLoginPwd.getText().toString();
                presenter.SetLogin(phone, pwd);
                break;
            case R.id.tv_backpsw:
                Intent intent = new Intent(LoginActivity.this,ChangedActivity.class);
                startActivity(intent);
                break;
            case R.id.zhuce:
                Intent intent1 = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent1);
                break;
        }

    }


}
