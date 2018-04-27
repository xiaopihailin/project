package com.example.godlight.sview;

import com.example.godlight.bean.RegisterYanBean;

/**
 * Created by lenovo on 2018/4/27.
 */

public interface RegisterView {
    void Failer();
    void Success(RegisterYanBean bean);
    void EmpatyPhone();
    void EmpatyPwd();
    void ReEmpatyPwd();
    void YanEmpaty();

}
