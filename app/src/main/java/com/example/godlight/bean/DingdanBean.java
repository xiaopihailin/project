package com.example.godlight.bean;

import java.util.List;

/**
 * Created by lenovo on 2018/4/28.
 */

public class DingdanBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"order_id":1,"order_service_id":1,"create_time":"2018-04-19 14:00:38","pre_time":"2018-04-19 13:45:24","order_number":"2018041910054505","order_user_id":1,"order_payment_type":"1","order_pay_price":null,"order_goods_status":4,"user_name":"李四","user_phone":"13521950346","service_name":"测试1","service_phone":"1888888888","hospital_address":"北京市大兴区黄村总医院","talk_address":"北京市北京市丰台区格雷众创园A","order_status_info":"已完成"},{"order_id":2,"order_service_id":1,"create_time":"2018-04-19 14:00:38","pre_time":"2018-04-19 13:45:24","order_number":"2018041910054506","order_user_id":2,"order_payment_type":"1","order_pay_price":null,"order_goods_status":2,"user_name":"张三","user_phone":"1212223322","service_name":"测试1","service_phone":"1888888888","hospital_address":"北京市大兴区黄村总医院","talk_address":"北京市北京市丰台区格雷众创园A","order_status_info":"待完成"},{"order_id":3,"order_service_id":1,"create_time":"2018-04-19 14:00:38","pre_time":"2018-04-19 13:45:24","order_number":"2018041910054507","order_user_id":2,"order_payment_type":"1","order_pay_price":null,"order_goods_status":2,"user_name":"张三","user_phone":"1212223322","service_name":"测试1","service_phone":"1888888888","hospital_address":"北京市大兴区黄村总医院","talk_address":"北京市北京市丰台区格雷众创园A","order_status_info":"待完成"},{"order_id":7,"order_service_id":1,"create_time":"2018-04-19 14:00:38","pre_time":"2018-04-19 13:45:24","order_number":"2018041910054511","order_user_id":2,"order_payment_type":"1","order_pay_price":null,"order_goods_status":2,"user_name":"张三","user_phone":"1212223322","service_name":"测试1","service_phone":"1888888888","hospital_address":"北京市大兴区黄村总医院","talk_address":"北京市北京市丰台区格雷众创园A","order_status_info":"待完成"},{"order_id":9,"order_service_id":1,"create_time":"2018-04-19 14:00:38","pre_time":"2018-04-19 13:45:24","order_number":"2018041910054513","order_user_id":1,"order_payment_type":"1","order_pay_price":null,"order_goods_status":4,"user_name":"李四","user_phone":"13521950346","service_name":"测试1","service_phone":"1888888888","hospital_address":"北京市大兴区黄村总医院","talk_address":"北京市北京市丰台区格雷众创园A","order_status_info":"已完成"},{"order_id":13,"order_service_id":1,"create_time":"2018-04-19 14:00:38","pre_time":"2018-04-19 13:45:24","order_number":"2018041910054517","order_user_id":1,"order_payment_type":"1","order_pay_price":null,"order_goods_status":4,"user_name":"李四","user_phone":"13521950346","service_name":"测试1","service_phone":"1888888888","hospital_address":"北京市大兴区黄村总医院","talk_address":"北京市北京市丰台区格雷众创园A","order_status_info":"已完成"}]
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
         * order_id : 1
         * order_service_id : 1
         * create_time : 2018-04-19 14:00:38
         * pre_time : 2018-04-19 13:45:24
         * order_number : 2018041910054505
         * order_user_id : 1
         * order_payment_type : 1
         * order_pay_price : null
         * order_goods_status : 4
         * user_name : 李四
         * user_phone : 13521950346
         * service_name : 测试1
         * service_phone : 1888888888
         * hospital_address : 北京市大兴区黄村总医院
         * talk_address : 北京市北京市丰台区格雷众创园A
         * order_status_info : 已完成
         */

        private int order_id;
        private int order_service_id;
        private String create_time;
        private String pre_time;
        private String order_number;
        private int order_user_id;
        private String order_payment_type;
        private Object order_pay_price;
        private int order_goods_status;
        private String user_name;
        private String user_phone;
        private String service_name;
        private String service_phone;
        private String hospital_address;
        private String talk_address;
        private String order_status_info;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public int getOrder_service_id() {
            return order_service_id;
        }

        public void setOrder_service_id(int order_service_id) {
            this.order_service_id = order_service_id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getPre_time() {
            return pre_time;
        }

        public void setPre_time(String pre_time) {
            this.pre_time = pre_time;
        }

        public String getOrder_number() {
            return order_number;
        }

        public void setOrder_number(String order_number) {
            this.order_number = order_number;
        }

        public int getOrder_user_id() {
            return order_user_id;
        }

        public void setOrder_user_id(int order_user_id) {
            this.order_user_id = order_user_id;
        }

        public String getOrder_payment_type() {
            return order_payment_type;
        }

        public void setOrder_payment_type(String order_payment_type) {
            this.order_payment_type = order_payment_type;
        }

        public Object getOrder_pay_price() {
            return order_pay_price;
        }

        public void setOrder_pay_price(Object order_pay_price) {
            this.order_pay_price = order_pay_price;
        }

        public int getOrder_goods_status() {
            return order_goods_status;
        }

        public void setOrder_goods_status(int order_goods_status) {
            this.order_goods_status = order_goods_status;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

        public String getService_name() {
            return service_name;
        }

        public void setService_name(String service_name) {
            this.service_name = service_name;
        }

        public String getService_phone() {
            return service_phone;
        }

        public void setService_phone(String service_phone) {
            this.service_phone = service_phone;
        }

        public String getHospital_address() {
            return hospital_address;
        }

        public void setHospital_address(String hospital_address) {
            this.hospital_address = hospital_address;
        }

        public String getTalk_address() {
            return talk_address;
        }

        public void setTalk_address(String talk_address) {
            this.talk_address = talk_address;
        }

        public String getOrder_status_info() {
            return order_status_info;
        }

        public void setOrder_status_info(String order_status_info) {
            this.order_status_info = order_status_info;
        }
    }
}
