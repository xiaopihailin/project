package com.example.godlight.ui.account;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.godlight.R;
import com.example.godlight.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/4/26.
 */

public class SettingsActivity extends BaseActivity {
    @Bind(R.id.image_back)
    ImageView imageBack;
    @Bind(R.id.uppwd_view)
    ImageView uppwdView;
    @Bind(R.id.uppwd_text)
    TextView uppwdText;
    @Bind(R.id.banben_view)
    ImageView banbenView;
    @Bind(R.id.dingdan_text)
    TextView dingdanText;
    @Bind(R.id.yingyong_view)
    ImageView yingyongView;
    @Bind(R.id.yingyong_text)
    TextView yingyongText;
    @Bind(R.id.guanyu_view)
    ImageView guanyuView;
    @Bind(R.id.guanyu_text)
    TextView guanyuText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_settings);
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

    @OnClick(R.id.image_back)
    public void onViewClicked() {
        finish();

    }
}
