package com.example.godlight.ui;


import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.godlight.R;
import com.example.godlight.base.BaseActivity;
import com.example.godlight.ui.account.FaDingActivity;
import com.example.godlight.ui.account.LoginActivity;
import com.example.godlight.ui.account.MineActivity;
import com.example.godlight.ui.account.ZiXunActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

   /* @Bind(R.id.tv_title)
    TextView tvTitle;*/
    @Bind(R.id.tv_order)
    TextView tvOrder;
    @Bind(R.id.tv_mine)
    TextView tvMine;
    @Bind(R.id.ll_title)
    LinearLayout llTitle;
     @Bind(R.id.tv_zixun)
    TextView tv_zixun;

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //BaseApplication.getInstance().addActivity(this);
    }

    @Override
    protected void initView() {
        /*tvTitle.setText("神灯");*/
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


    @OnClick({R.id.tv_order, R.id.tv_mine,R.id.tv_zixun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_order:
                Intent intent1 = new Intent(MainActivity.this, FaDingActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_zixun:
                Intent intent2 = new Intent(MainActivity.this, ZiXunActivity.class);
                startActivity(intent2);
                break;
            case R.id.tv_mine:
              //  Toast.makeText(this,"点击了",Toast.LENGTH_LONG).show();
               Intent intent =new Intent(this, MineActivity.class);
                startActivity(intent);
                break;
        }
    }
}
