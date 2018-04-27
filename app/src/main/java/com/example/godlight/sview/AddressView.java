package com.example.godlight.sview;

import com.example.godlight.bean.AddressBean;
import com.example.godlight.bean.LoginBean;

/**
 * Created by lenovo on 2018/4/27.
 */

public interface AddressView {
    void Success(AddressBean bean);
    void SuccessShan(LoginBean bean);
    void Failer(String s);
    void ShanData();
}
