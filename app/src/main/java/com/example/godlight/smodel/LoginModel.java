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


       /* OkHttpClient client = new OkHttpClient();
        FormBody.Builder formbody = new FormBody.Builder();
        formbody.add("user_phone",phone);
        formbody.add("password",pwd);
        FormBody body = formbody.build();
        Request request = new Request.Builder()
                .url("http://192.168.1.12/api/Login/index")
                .post(body)//请求体
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("onFailure",e+"");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseBody = response.body().string();
                Gson gson = new Gson();
                LoginBean bean = gson.fromJson(responseBody, LoginBean.class);
                Log.i("onResponse",bean.getMsg()+"");
            }
        });*/

    }
}
