package com.example.godlight.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/2/3.
 */

public class Api {
    public static ApiServer apiServer;
    //http://192.168.1.48/shengdeng/php/91SD/public/api/Login/index
   // http://192.168.1.12/api/Login/index?user_phone=13521950346&password=123456
    //  http://192.168.1.48/shengdeng/php/91SD/public/api/Login/index
    public static String path="http://192.168.1.48/shengdeng/php/91SD/public/api/";
    public static ApiServer getInstance(){
        if(apiServer==null){
            synchronized (ApiServer.class){
                if(apiServer==null){
                    new Api();
                }
            }
        }
        return apiServer;
    }


    public Api() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
         apiServer = retrofit.create(ApiServer.class);

    }
}
