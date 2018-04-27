package com.example.godlight.ui.account;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.godlight.R;
import com.example.godlight.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/4/26.
 */

public class ChangedActivity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.zixun)
    TextView zixun;
    @Bind(R.id.ll_title)
    RelativeLayout llTitle;
    @Bind(R.id.pwd)
    EditText pwd;
    @Bind(R.id.shurupwd)
    EditText shurupwd;
    @Bind(R.id.jingshi)
    ImageView jingshi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    protected void loadView() {
        setContentView(R.layout.activity_uppwd);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        zixun.setText("修改密码");
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



    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
