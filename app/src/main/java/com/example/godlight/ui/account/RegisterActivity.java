package com.example.godlight.ui.account;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.godlight.R;
import com.example.godlight.base.BaseActivity;
import com.example.godlight.base.BaseApplication;
import com.example.godlight.view.ClearEditText;
import com.example.godlight.view.TimerTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RegisterActivity extends BaseActivity implements View.OnFocusChangeListener, TextWatcher {
    private final String mPageName = "RegisterActivity";
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ll_title)
    RelativeLayout llTitle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStatusBarColor(R.color.white);

    }

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_register);
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
            case R.id.tv_timer:
                tvTimer.start();
                tvTimer.setTimes(60);
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
                break;
        }
    }
}
