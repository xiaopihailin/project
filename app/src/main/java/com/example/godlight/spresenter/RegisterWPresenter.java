package com.example.godlight.spresenter;

import com.example.godlight.bean.LoginBean;
import com.example.godlight.bean.RegisterYanBean;
import com.example.godlight.smodel.RegisterWModel;
import com.example.godlight.sview.RegisterWView;
import com.example.godlight.ui.account.RegisterSecondeActivity;

/**
 * Created by lenovo on 2018/4/27.
 */

public class RegisterWPresenter {
    private boolean flag=true;
    private RegisterWView view;
    private RegisterWModel model;
    public RegisterWPresenter(RegisterWView view) {
        this.view=view;
        this.model=new RegisterWModel();
    }

    public void GetData(String user_phone, String password, String name, String address) {
        setFlag(name,address);
        if(flag){
            model.GetData(user_phone,password,name,address, new ZhuFlag() {
                @Override
                public void Success(LoginBean bean) {
                    view.Success(bean);
                }
            });
        }
    }


    public interface ZhuFlag{
        void Success(LoginBean bean);
    }



    public void setFlag(String name, String address){
        if(name==null||name.equals("")){
            view.NameEmpty();
            flag=false;
        }else{
            flag=true;
        }
        if(flag){
            if(address==null||address.equals("")){
                view.AddressEmpty();
                flag=false;
            }else{
                flag=true;
            }
        }


    }

}
