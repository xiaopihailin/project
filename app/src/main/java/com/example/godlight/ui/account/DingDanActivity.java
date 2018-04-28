package com.example.godlight.ui.account;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.godlight.fragment.AllDingdanFragment;
import com.example.godlight.R;
import com.example.godlight.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/4/28.
 */

public class DingDanActivity extends BaseActivity {
    @Bind(R.id.quanbu)
    TextView quanbu;
    @Bind(R.id.daiwancheng)
    TextView daiwancheng;
    @Bind(R.id.yiwancheng)
    TextView yiwancheng;
    @Bind(R.id.daipingjia)
    TextView daipingjia;
    @Bind(R.id.linea_fragment)
    LinearLayout lineaFragment;
    private FragmentManager fm;
    private FragmentTransaction mfragmentTransaction;
    private AllDingdanFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        ////在系统中原生的Fragment是通过getFragmentManager获得的。
        fm = getFragmentManager();
        //2.开启一个事务，通过调用beginTransaction方法开启。
        mfragmentTransaction = fm.beginTransaction();
    }

    @Override
    protected void loadView() {
        setContentView(R.layout.mine_dingdanactivity);
    }

    @Override
    protected void initView() {
        fragment = new AllDingdanFragment();

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

    @OnClick({R.id.quanbu, R.id.daiwancheng, R.id.yiwancheng, R.id.daipingjia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.quanbu:
                mfragmentTransaction.replace(R.id.linea_fragment,fragment);
                break;
            case R.id.daiwancheng:


                break;
            case R.id.yiwancheng:


                break;
            case R.id.daipingjia:

                break;

        }
    }
}
