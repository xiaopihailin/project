package com.example.godlight.smodel;

import android.content.Context;
import android.util.Log;

import com.example.godlight.bean.LoginBean;
import com.example.godlight.net.ApiMethod;
import com.example.godlight.net.MyObserver;
import com.example.godlight.net.ObserverOnNextListener;
import com.example.godlight.spresenter.RegisterWPresenter;
import com.example.godlight.ui.account.RegisterSecondeActivity;

import java.util.HashMap;

/**
 * Created by lenovo on 2018/4/27.
 */

public class RegisterWModel {
        Context context;

    public RegisterWModel() {

    }

    public RegisterWModel(Context context) {
        this.context=context;
    }

    public void GetData(String user_phone, String password, String name, String address, final RegisterWPresenter.ZhuFlag zhuFlag) {
        ObserverOnNextListener<LoginBean> listener = new ObserverOnNextListener<LoginBean>() {
            @Override
            public void onNext(LoginBean loginBean) {
               // Log.i("loginBean",loginBean.getMsg()+"");
                zhuFlag.Success(loginBean);
            }
        };
        HashMap<String, String> map = new HashMap<>();
        map.put("user_phone",user_phone);
        map.put("password",password);
        map.put("user_name",name);
        map.put("user_address ",address);
        ApiMethod.getZhuce(new MyObserver<LoginBean>(context,listener),map);
    }
}
