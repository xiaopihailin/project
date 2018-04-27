package com.example.godlight.sview;

import com.example.godlight.bean.LoginBean;

/**
 * Created by lenovo on 2018/4/27.
 */

public interface RegisterWView {
    void  Success(LoginBean bean);
    void  NameEmpty();
    void  AddressEmpty();
}
