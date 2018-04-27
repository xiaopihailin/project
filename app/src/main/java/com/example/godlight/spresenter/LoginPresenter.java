package com.example.godlight.spresenter;

import com.example.godlight.bean.LoginBean;
import com.example.godlight.smodel.LoginModel;
import com.example.godlight.sview.LoginView;
import com.example.godlight.ui.account.LoginActivity;

/**
 * Created by lenovo on 2018/4/25.
 */

public class LoginPresenter {
    private boolean flag=true;
    private LoginView view;
    private LoginModel model;
    public LoginPresenter(LoginView view) {
        this.view=view;
        model=new LoginModel();
    }

    public void SetLogin(String phone, String pwd) {
        setFlag(phone, pwd, new LoginFlag() {
            @Override
            public void Success(LoginBean bean) {

            }

            @Override
            public void Failer(String s) {

            }
        });
        if (flag) {
            model.SetLogin(phone, pwd, new LoginFlag() {
                @Override
                public void Success(LoginBean bean) {
                    view.Success(bean);
                }

                @Override
                public void Failer(String s) {
                    view.Failer(s);
                }
            });
        }
    }

    public interface LoginFlag{
        void Success(LoginBean bean);
        void Failer(String s);
    }

    public void setFlag(String phone, String pwd, LoginFlag loginFlag){
        if(phone==null||phone.equals("")){
            view.EmpatyPhone();
            flag=false;
        }else{
            flag=true;
        }
        if(flag){
            if(pwd==null||pwd.equals("")){
                view.EmpatyPwd();
                flag=false;
            }else{
                flag=true;
            }
        }
    }
}
