package com.example.godlight.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class MineActivity extends BaseActivity {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.zixun)
    TextView zixun;
    @Bind(R.id.image_view)
    ImageView imageView;
    @Bind(R.id.text_name)
    TextView textName;
    @Bind(R.id.phone_wode)
    TextView phoneWode;
    @Bind(R.id.relative2)
    RelativeLayout relative2;
    @Bind(R.id.dingdan_view)
    ImageView dingdanView;
    @Bind(R.id.dingdan_text)
    TextView dingdanText;
    @Bind(R.id.pingfen_view)
    ImageView pingfenView;
    @Bind(R.id.pingfen_text)
    TextView pingfenText;
    @Bind(R.id.fuwu_view)
    ImageView fuwuView;
    @Bind(R.id.fuwu_text)
    TextView fuwuText;
    @Bind(R.id.dizhi_view)
    ImageView dizhiView;
    @Bind(R.id.dizhi_text)
    TextView dizhiText;
    @Bind(R.id.renzheng_view)
    ImageView renzhengView;
    @Bind(R.id.renzheng_text)
    TextView renzhengText;
    @Bind(R.id.iv_settings)
    ImageView ivSettings;
    @Bind(R.id.dizhi_relative)
    RelativeLayout dizhiRelative;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_mine);
        ButterKnife.bind(this);
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

    @OnClick({R.id.iv_back, R.id.iv_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_settings:
                Intent intent = new Intent(MineActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
    }


    @OnClick(R.id.dizhi_relative)
    public void onViewClicked() {
        Intent intent = new Intent(MineActivity.this,AddressActivity.class);
        startActivity(intent);
    }
}
