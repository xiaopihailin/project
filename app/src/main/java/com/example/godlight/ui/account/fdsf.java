package com.example.godlight.ui.account;

import java.util.List;

/**
 * Created by lenovo on 2018/4/27.
 */

public class fdsf {

    /**
     * code : 1
     * msg : 数据返回中！
     * data : [{"address_id":1,"user_id":1,"user_name":null,"user_phone":"12345678901","user_phone_two":null,"take_pro":"北京","take_city":"丰田","take_area":"神州科技园","take_street":"1","hospital_pro":null,"hospital_city":null,"hospital_area":null,"hospital_address_info":null,"if_default":0,"if_del":0},{"address_id":2,"user_id":1,"user_name":null,"user_phone":"12345678941","user_phone_two":null,"take_pro":"北京","take_city":"海淀","take_area":"黄庄","take_street":"1","hospital_pro":null,"hospital_city":null,"hospital_area":null,"hospital_address_info":null,"if_default":0,"if_del":0},{"address_id":3,"user_id":1,"user_name":null,"user_phone":"12345678901","user_phone_two":null,"take_pro":"北京","take_city":"大兴","take_area":"高米店","take_street":"0","hospital_pro":null,"hospital_city":null,"hospital_area":null,"hospital_address_info":null,"if_default":1,"if_del":0}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * address_id : 1
         * user_id : 1
         * user_name : null
         * user_phone : 12345678901
         * user_phone_two : null
         * take_pro : 北京
         * take_city : 丰田
         * take_area : 神州科技园
         * take_street : 1
         * hospital_pro : null
         * hospital_city : null
         * hospital_area : null
         * hospital_address_info : null
         * if_default : 0
         * if_del : 0
         */

        private int address_id;
        private int user_id;
        private Object user_name;
        private String user_phone;
        private Object user_phone_two;
        private String take_pro;
        private String take_city;
        private String take_area;
        private String take_street;
        private Object hospital_pro;
        private Object hospital_city;
        private Object hospital_area;
        private Object hospital_address_info;
        private int if_default;
        private int if_del;

        public int getAddress_id() {
            return address_id;
        }

        public void setAddress_id(int address_id) {
            this.address_id = address_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public Object getUser_name() {
            return user_name;
        }

        public void setUser_name(Object user_name) {
            this.user_name = user_name;
        }

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

        public Object getUser_phone_two() {
            return user_phone_two;
        }

        public void setUser_phone_two(Object user_phone_two) {
            this.user_phone_two = user_phone_two;
        }

        public String getTake_pro() {
            return take_pro;
        }

        public void setTake_pro(String take_pro) {
            this.take_pro = take_pro;
        }

        public String getTake_city() {
            return take_city;
        }

        public void setTake_city(String take_city) {
            this.take_city = take_city;
        }

        public String getTake_area() {
            return take_area;
        }

        public void setTake_area(String take_area) {
            this.take_area = take_area;
        }

        public String getTake_street() {
            return take_street;
        }

        public void setTake_street(String take_street) {
            this.take_street = take_street;
        }

        public Object getHospital_pro() {
            return hospital_pro;
        }

        public void setHospital_pro(Object hospital_pro) {
            this.hospital_pro = hospital_pro;
        }

        public Object getHospital_city() {
            return hospital_city;
        }

        public void setHospital_city(Object hospital_city) {
            this.hospital_city = hospital_city;
        }

        public Object getHospital_area() {
            return hospital_area;
        }

        public void setHospital_area(Object hospital_area) {
            this.hospital_area = hospital_area;
        }

        public Object getHospital_address_info() {
            return hospital_address_info;
        }

        public void setHospital_address_info(Object hospital_address_info) {
            this.hospital_address_info = hospital_address_info;
        }

        public int getIf_default() {
            return if_default;
        }

        public void setIf_default(int if_default) {
            this.if_default = if_default;
        }

        public int getIf_del() {
            return if_del;
        }

        public void setIf_del(int if_del) {
            this.if_del = if_del;
        }
    }
}
