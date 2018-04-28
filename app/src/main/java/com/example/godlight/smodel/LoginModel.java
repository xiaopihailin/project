package com.example.godlight.smodel;

import android.content.Context;
import android.util.Log;

import com.example.godlight.bean.LoginBean;
import com.example.godlight.net.ApiMethod;
import com.example.godlight.net.ApiServer;
import com.example.godlight.net.MyObserver;
import com.example.godlight.net.ObserverOnNextListener;
import com.example.godlight.net.RetrofitHelper;
import com.example.godlight.spresenter.LoginPresenter;
import com.example.godlight.ui.account.LoginActivity;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by lenovo on 2018/4/25.
 */

public class LoginModel {

    Context context;
    public LoginModel(Context context) {
        this.context=context;
    }

    public LoginModel() {

    }

    public void SetLogin(String phone, String pwd, final LoginPresenter.LoginFlag loginFlag) {
        ObserverOnNextListener<LoginBean> listener = new ObserverOnNextListener<LoginBean>() {
            @Override
            public void onNext(LoginBean loginBean) {
                Log.i("onnext",loginBean.getMsg()+"");
                loginFlag.Success(loginBean);
            }
        };

        HashMap<String, String> map = new HashMap<>();
        map.put("user_phone",phone);
        map.put("password",pwd);
        ApiMethod.getTopMovies(new MyObserver<LoginBean>(context,listener),map);


    }
}
