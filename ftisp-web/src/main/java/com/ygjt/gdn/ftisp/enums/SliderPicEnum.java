package com.ygjt.gdn.ftisp.enums;

/**
 * Created by zzy on 2017/5/7.
 */
public class SliderPicEnum {
    public enum SLIDER_TYPE {
        NEWS_CENTER("C","资讯中心"),
        INDEX("I","首页"),
        ;

        private String value;
        private String name;

        SLIDER_TYPE( String value,String name) {
            this.value = value;
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static SliderPicEnum.SLIDER_TYPE parse(String value) {
            for (SliderPicEnum.SLIDER_TYPE type : SliderPicEnum.SLIDER_TYPE.values()) {
                if (type.value.equals(value)) {
                    return type;
                }
            }
            return null;
        }
    }
}
