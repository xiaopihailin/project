package com.example.godlight.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.godlight.R;
import com.example.godlight.adapter.AddressAdapter;
import com.example.godlight.base.BaseActivity;
import com.example.godlight.bean.AddressBean;
import com.example.godlight.bean.LoginBean;
import com.example.godlight.smodel.AddressModel;
import com.example.godlight.spresenter.AddressPresenter;
import com.example.godlight.sview.AddressView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2018/4/27.
 */

public class AddressActivity extends BaseActivity implements AddressView {
    @Bind(R.id.image_bacl)
    ImageView imageBacl;
    @Bind(R.id.reclerview)
    RecyclerView reclerview;
    @Bind(R.id.button_add)
    Button buttonAdd;
    @Bind(R.id.btn_login)
    RelativeLayout btnLogin;
    private AddressPresenter presenter;
    private AddressModel model;
    private AddressAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        reclerview.setLayoutManager(new LinearLayoutManager(AddressActivity.this, LinearLayoutManager.VERTICAL, false));
        presenter.getData();
    }

    @Override
    protected void loadView() {
        setContentView(R.layout.activity_addresss);

    }

    @Override
    protected void initView() {
        presenter = new AddressPresenter(this);
        model = new AddressModel(this);

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
    public void Success(AddressBean bean) {
        //Log.i("addressSuccess",bean.getData());
        adapter = new AddressAdapter(AddressActivity.this, bean.getData());
        reclerview.setAdapter(adapter);

    }

    @Override
    public void SuccessShan(LoginBean bean) {
        Toast.makeText(AddressActivity.this, bean.getMsg(), Toast.LENGTH_SHORT).show();
        if (bean.getMsg().equals("删除成功！")) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void Failer(String s) {

    }

    @Override
    public void ShanData() {

    }

    public void ShanchuAddress(int id) {
        presenter.ShanData(id);

    }

    @OnClick(R.id.button_add)
    public void onViewClicked() {
        Intent intent = new Intent(AddressActivity.this,AddJiaActivity.class);
        startActivity(intent);
    }
}
