package com.example.godlight.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.godlight.R;
import com.example.godlight.base.BaseActivity;
import com.example.godlight.bean.LoginBean;
import com.example.godlight.smodel.RegisterWModel;
import com.example.godlight.spresenter.RegisterWPresenter;
import com.example.godlight.sview.RegisterWView;
import com.example.godlight.view.ClearEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/4/27.
 */

public class RegisterSecondeActivity extends BaseActivity implements RegisterWView {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ll_title)
    RelativeLayout llTitle;
    @Bind(R.id.huanying)
    LinearLayout huanying;
    @Bind(R.id.et_account_name)
    ClearEditText etAccountName;
    @Bind(R.id.rl_account)
    RelativeLayout rlAccount;
    @Bind(R.id.et_account_address)
    ClearEditText etAccountAddress;
    @Bind(R.id.btn_register)
    Button btnRegister;
    private RegisterWPresenter presenter;
    private String user_phone;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        user_phone = intent.getStringExtra("user_phone");
        password = intent.getStringExtra("password");
    }

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_reregitster);
    }

    @Override
    protected void initView() {
        presenter = new RegisterWPresenter(this);
        RegisterWModel model = new RegisterWModel(this);
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



    @Override
    public void Success(LoginBean bean) {
        Toast.makeText(RegisterSecondeActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
        if(bean.getMsg().equals("注册成功")){
            Intent intent = new Intent(RegisterSecondeActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void NameEmpty() {
        Toast.makeText(RegisterSecondeActivity.this,"姓名不能为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void AddressEmpty() {
        Toast.makeText(RegisterSecondeActivity.this,"地址不能为空",Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.btn_register)
    public void onViewClicked() {
        Toast.makeText(RegisterSecondeActivity.this,"点击了",Toast.LENGTH_SHORT).show();
        presenter.GetData(user_phone,password,etAccountName.getText().toString().trim(),etAccountAddress.getText().toString().trim());

    }
}
