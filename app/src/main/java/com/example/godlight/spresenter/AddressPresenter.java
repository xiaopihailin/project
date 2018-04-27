package com.example.godlight.spresenter;

import com.example.godlight.bean.AddressBean;
import com.example.godlight.bean.LoginBean;
import com.example.godlight.smodel.AddressModel;
import com.example.godlight.sview.AddressView;
import com.example.godlight.ui.account.AddressActivity;
import com.example.godlight.ui.account.LoginActivity;

/**
 * Created by lenovo on 2018/4/27.
 */

public class AddressPresenter {
    private AddressView view;
    private AddressModel model;
    public AddressPresenter(AddressView view) {
        this.view=view;
        this.model=new AddressModel();
    }

    public void getData() {

        model.getData(new LoginFlag() {
            @Override
            public void Success(AddressBean bean) {
                view.Success(bean);
            }

            @Override
            public void Failer(String s) {

            }
        });

    }

    public void ShanData(int id) {
       model.ShanData(id, new ShanFlag() {
           @Override
           public void Success(LoginBean bean) {
               view.SuccessShan(bean);
           }
       });

    }

    public interface LoginFlag{
        void Success(AddressBean bean);
        void Failer(String s);
    }
    public interface ShanFlag{
        void Success(LoginBean bean);
    }
}
