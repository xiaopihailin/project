package com.example.godlight.sview;

import com.example.godlight.bean.LoginBean;

/**
 * Created by lenovo on 2018/4/25.
 */

public interface LoginView {
    void Success(LoginBean bean);
    void Failer(String s);
    void EmpatyPhone();
    void EmpatyPwd();
}
