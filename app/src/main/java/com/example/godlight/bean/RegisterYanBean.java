package com.example.godlight.bean;

/**
 * Created by lenovo on 2018/4/27.
 */

public class RegisterYanBean {

    /**
     * code : -4
     * msg : 验证码不正确
     * data : {"1":"123"}
     */

    private String code;
    private String msg;
    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
