package com.example.godlight.net;


import com.example.godlight.bean.LoginBean;
import com.example.godlight.bean.RegisterBean;
import com.example.godlight.bean.RegisterYanBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2018/2/3.
 */

public interface ApiServer {
    // http://192.168.1.12/api/Login/index?user_phone=13521950346&password=123456
    @GET("Login/index")
    Observable<LoginBean> get(@QueryMap HashMap<String, String> map);

    @GET("Userlogin/send")
    Observable<RegisterBean> RegisterSendYan(@QueryMap HashMap<String, String> map);

    @GET("Userlogin/sendVerification")
    Observable<RegisterYanBean> RegisterPanYan(@QueryMap HashMap<String, String> map);
}
