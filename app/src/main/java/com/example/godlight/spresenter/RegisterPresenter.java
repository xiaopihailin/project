package com.example.godlight.spresenter;

import com.example.godlight.bean.LoginBean;
import com.example.godlight.bean.RegisterBean;
import com.example.godlight.bean.RegisterYanBean;
import com.example.godlight.smodel.RegisterModel;
import com.example.godlight.sview.RegisterView;
import com.example.godlight.ui.account.RegisterActivity;

/**
 * Created by lenovo on 2018/4/27.
 */

public class RegisterPresenter {
    private boolean flag=true;
    private RegisterView registerView;
    private RegisterModel model;
    public RegisterPresenter(RegisterView registerView) {
        this.registerView=registerView;
        this.model=new RegisterModel();
    }

    public void GetData(String phone, String pwd) {
        setFlag(phone,pwd);
        if(flag){
            model.GetZhucePanYan(phone,pwd, new ZhuFlag() {
                @Override
                public void Success(RegisterYanBean bean) {
                    registerView.Success(bean);
                }

                @Override
                public void Failer(String s) {

                }
            });


        }
    }

    public interface ZhuFlag{
        void Success(RegisterYanBean bean);
        void Failer(String s);
    }




    public void setFlag(String phone, String pwd){
        if(phone==null||phone.equals("")){
            registerView.EmpatyPhone();
            flag=false;
        }else{
            flag=true;
        }
        if(flag){
            if(pwd==null||pwd.equals("")){
                registerView.EmpatyPwd();
                flag=false;
            }else{
                flag=true;
            }
        }


    }

    public void GetYanMa(String phone) {
        model.GetYanMa(phone);

    }
}
