package com.ygjt.gdn.ftisp.enums;

/**
 * Created by linx on 2017-04-20.
 */
public class EmailCodeEnum {
    public enum TYPE {
        EMAIL_TYPE_REGISTER("注册邮件", "0","register"),
        EMAIL_TYPE_FORGET_PWD("找回密码邮件", "1","forget_password");

        private String name;
        private String value;
        private String front_value;


        TYPE(String value, String name) {
            this.name = name;
            this.value = value;
        }

        TYPE(String name, String value, String front_value) {
            this.name = name;
            this.value = value;
            this.front_value = front_value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getFront_value() {
            return front_value;
        }

        public void setFront_value(String front_value) {
            this.front_value = front_value;
        }
        public static TYPE parse(String value) {
            for (TYPE type : TYPE.values()) {
                if (type.front_value.equals(value)) {
                    return type;
                }
            }
            return null;
        }
    }
    public enum ACTIVED {
        Y,N;
    }
}
