package com.example.godlight.net;


import com.example.godlight.bean.AddressBean;
import com.example.godlight.bean.DingdanBean;
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
    @GET("Userlogin/index")
    Observable<LoginBean> get(@QueryMap HashMap<String, String> map);

    @GET("Userlogin/send")
    Observable<RegisterBean> RegisterSendYan(@QueryMap HashMap<String, String> map);

    @GET("Userlogin/sendVerification")
    Observable<RegisterYanBean> RegisterPanYan(@QueryMap HashMap<String, String> map);
    //所有地址
    //http://192.168.1.48/shengdeng/php/91SD/public/api/Useraddress/addressIndex
    @GET("Useraddress/addressIndex")
    Observable<AddressBean> getaddress(@QueryMap HashMap<String, String> map);

    //所有地址
    //http://192.168.1.48/shengdeng/php/91SD/public/api/Useraddress/addressIndex
    @GET("login/register")
    Observable<LoginBean> getZhuce(@QueryMap HashMap<String, String> map);

    //删除地址
    //http://192.168.1.48/shengdeng/php/91SD/public/api/Useraddress/addressIndex
    @GET("Useraddress/addressDel")
    Observable<LoginBean> Shanchu(@QueryMap HashMap<String, String> map);
    //全部订单
    @GET("order/orderServiceAll")
    Observable<DingdanBean> AllQuanDingdan(@QueryMap HashMap<String, String> map);
}
