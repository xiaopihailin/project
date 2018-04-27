package com.example.godlight.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    public static OkHttpClient client;
    public static ApiServer apiServer;

    private RetrofitHelper() {

    }

    public static OkHttpClient getClient() {
        if (client == null){
            synchronized (OkHttpClient.class){
                if (client == null){
                    client = new OkHttpClient();
                }
            }
        }
        return client;
    }
    public static ApiServer getServerApi(){
        if (apiServer == null){
            synchronized (Api.class){
                if (apiServer == null){
                    apiServer = OnCreate(ApiServer.class,Api.path);
                }
            }
        }
        return apiServer;
    }
    public static <T> T OnCreate(Class<T> tClass,String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}