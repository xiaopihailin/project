package com.example.godlight.ui.account;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.godlight.R;
import com.example.godlight.base.BaseActivity;
import com.example.godlight.bean.RegisterYanBean;
import com.example.godlight.smodel.RegisterModel;
import com.example.godlight.spresenter.RegisterPresenter;
import com.example.godlight.sview.RegisterView;
import com.example.godlight.view.ClearEditText;
import com.example.godlight.view.TimerTextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class RegisterActivity extends BaseActivity implements View.OnFocusChangeListener, TextWatcher ,RegisterView{
    private final String mPageName = "RegisterActivity";
    @Bind(R.id.huanying)
    LinearLayout huanying;
    @Bind(R.id.zc_iv_sms_code_imageview)
    ImageView zcIvSmsCodeImageview;
    @Bind(R.id.zc_et_sms_code)
    ClearEditText zcEtSmsCode;
    @Bind(R.id.zc_view_sms_code)
    View zcViewSmsCode;
    @Bind(R.id.zc_view_account)
    View zcViewAccount;
    @Bind(R.id.zaici_pwd)
    RelativeLayout zaiciPwd;
    @Bind(R.id.radio_button)
    RadioButton radioButton;
    private String flag = "获取验证码";

    @Bind(R.id.iv_account)
    ImageView ivAccount;
    @Bind(R.id.et_account)
    ClearEditText etAccount;
    @Bind(R.id.tv_timer)
    TimerTextView tvTimer;
    @Bind(R.id.view_account)
    View viewAccount;
    @Bind(R.id.rl_account)
    RelativeLayout rlAccount;
    @Bind(R.id.iv_sms_code)
    ImageView ivSmsCode;
    @Bind(R.id.et_sms_code)
    ClearEditText etSmsCode;
    @Bind(R.id.view_sms_code)
    View viewSmsCode;
    @Bind(R.id.rl_sms_code)
    RelativeLayout rlSmsCode;
    @Bind(R.id.iv_pwd)
    ImageView ivPwd;
    @Bind(R.id.et_login_pwd)
    ClearEditText etLoginPwd;
    @Bind(R.id.view_pwd)
    View viewPwd;
    @Bind(R.id.rl_pwd)
    RelativeLayout rlPwd;
    @Bind(R.id.btn_register)
    Button btnRegister;
    private RegisterPresenter presenter;
    private RegisterModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStatusBarColor(R.color.white);

    }

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter = new RegisterPresenter(this);
        model = new RegisterModel(this);
    }

    @Override
    protected void setAllEvent() {

    }

    @Override
    protected void progress() {

    }

    /**
     * 文本框监听
     *
     * @param s
     * @param start
     * @param count
     * @param after
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {


    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {

    }

    @OnClick({R.id.et_account, R.id.tv_timer, R.id.rl_account, R.id.iv_sms_code, R.id.et_sms_code, R.id.rl_sms_code, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_account:
                break;
                //验证码获取
            case R.id.tv_timer:
                String phone = etAccount.getText().toString();
                if(phone==null||phone.equals("")){
                    Toast.makeText(RegisterActivity.this,"请输入手机号",Toast.LENGTH_SHORT).show();
                }else{
                    String times = tvTimer.getTimes();
                    if (times.equals(flag)) {
                        tvTimer.start();
                        tvTimer.setTimes(60);
                    } else {
                        tvTimer.setToast();
                    }
                    presenter.GetYanMa(phone+"");
                }
                break;
            case R.id.rl_account:
                break;
            case R.id.iv_sms_code:
                break;
            case R.id.et_sms_code:
                break;
            case R.id.rl_sms_code:
                break;
            case R.id.btn_register:
               presenter.GetData(etAccount.getText().toString().trim(),etSmsCode.getText().toString().trim());


                break;
        }
    }

    @Override
    public void Failer() {

    }

    @Override
    public void Success(RegisterYanBean bean) {
        Log.i("beanregister",bean.getMsg()+"");
        //Toast.makeText(RegisterActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
        if(bean.getMsg().equals("验证成功")){
            Intent intent = new Intent(RegisterActivity.this, RegisterSecondeActivity.class);
            intent.putExtra("user_phone",etAccount.getText().toString());
            intent.putExtra("password",etLoginPwd.getText().toString());
            startActivity(intent);
        }
    }

    @Override
    public void EmpatyPhone() {
        Toast.makeText(RegisterActivity.this,"请输入手机号",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void EmpatyPwd() {
        Toast.makeText(RegisterActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void ReEmpatyPwd() {
        Toast.makeText(RegisterActivity.this,"请再次输入密码",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void YanEmpaty() {
        Toast.makeText(RegisterActivity.this,"请输入验证码",Toast.LENGTH_SHORT).show();

    }
}
