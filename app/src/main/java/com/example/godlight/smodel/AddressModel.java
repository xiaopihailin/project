package com.example.godlight.smodel;

import android.content.Context;
import android.util.Log;

import com.example.godlight.bean.AddressBean;
import com.example.godlight.bean.LoginBean;
import com.example.godlight.net.ApiMethod;
import com.example.godlight.net.MyObserver;
import com.example.godlight.net.ObserverOnNextListener;
import com.example.godlight.spresenter.AddressPresenter;
import com.example.godlight.ui.account.LoginActivity;

import java.util.HashMap;


public class AddressModel {
    Context context;

    public AddressModel() {

    }

    public AddressModel(Context context) {
        this.context=context;
    }

    public void getData(final AddressPresenter.LoginFlag loginFlag) {
        ObserverOnNextListener<AddressBean> listener = new ObserverOnNextListener<AddressBean>() {
            @Override
            public void onNext(AddressBean bean) {
               /* Log.i("addressbean",bean.getMsg());*/
               loginFlag.Success(bean);
            }
        };

        HashMap<String, String> map = new HashMap<>();
        ApiMethod.getAddress(new MyObserver<AddressBean>(context,listener),map);


    }

    public void ShanData(int id, final AddressPresenter.ShanFlag shanFlag) {
        ObserverOnNextListener<LoginBean> listener = new ObserverOnNextListener<LoginBean>() {
            @Override
            public void onNext(LoginBean bean) {
                Log.i("shanchu",bean.getMsg());
                shanFlag.Success(bean);
            }
        };

        HashMap<String, String> map = new HashMap<>();
        map.put("address_id",id+"");
        ApiMethod.Shanaddress(new MyObserver<LoginBean>(context,listener),map);

    }
}
