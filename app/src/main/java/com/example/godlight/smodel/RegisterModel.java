package com.example.godlight.smodel;

import android.content.Context;
import android.util.Log;

import com.example.godlight.bean.LoginBean;
import com.example.godlight.bean.RegisterBean;
import com.example.godlight.bean.RegisterYanBean;
import com.example.godlight.net.ApiMethod;
import com.example.godlight.net.MyObserver;
import com.example.godlight.net.ObserverOnNextListener;
import com.example.godlight.spresenter.RegisterPresenter;
import com.example.godlight.ui.account.RegisterActivity;

import java.util.HashMap;

/**
 * Created by lenovo on 2018/4/27.
 */

public class RegisterModel {
    Context context;
    public RegisterModel() {

    }

    public RegisterModel(Context context) {
        this.context=context;
    }

    public void GetYanMa(String phone) {
        Log.i("StringPhone",""+phone);
        ObserverOnNextListener<RegisterBean> listener = new ObserverOnNextListener<RegisterBean>() {
            @Override
            public void onNext(RegisterBean registerBean) {
                String msg = registerBean.getMsg();
                Log.i("msgshang",msg);

            }
        };
        HashMap<String, String> map = new HashMap<>();
        map.put("user_phone",phone);
        ApiMethod.getRegusterYan(new MyObserver<RegisterBean>(context,listener),map);
    }



    public void GetZhucePanYan(String phone, String yanzhengma, final RegisterPresenter.ZhuFlag zhuFlag) {

        ObserverOnNextListener<RegisterYanBean> listener = new ObserverOnNextListener<RegisterYanBean>() {
            @Override
            public void onNext(RegisterYanBean registerYanBean) {
                String msg = registerYanBean.getMsg();
                Log.i("msgYan:",""+msg);
                zhuFlag.Success(registerYanBean);
            }
        };
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("user_phone",phone);
        map1.put("verification",yanzhengma);

        ApiMethod.getRegusterPanYan(new MyObserver<RegisterYanBean>(context,listener),map1);
    }
}
