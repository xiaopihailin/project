package com.example.godlight.net;


import com.example.godlight.bean.LoginBean;

import java.util.HashMap;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/2/3.
 */

public class ApiMethod {
    public static void ApiSubscribe(Observable observable, Observer observer){
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    public static  void getTopMovies(Observer<LoginBean> observer, HashMap<String, String> map){

        ApiSubscribe(Api.getInstance().get(map),observer);
    }


}
