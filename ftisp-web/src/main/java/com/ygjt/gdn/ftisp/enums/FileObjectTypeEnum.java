package com.ygjt.gdn.ftisp.enums;

/**
 * Created by wyh on 2016/11/11.
 */
public class FileObjectTypeEnum {
    public enum objectType{
        ENTERBSLICENSE("EnterBsLicense","营业执照"),
        ENTERTAX("EnterTax","税务登记证"),
        ENTERORGANCODE("EnterOrganCode","组织机构代码证"),
        GOODS("Goods","商品图片")
        ;

        private String name;
        private String  value;
        objectType(String value, String name) {
            this.name = name;
            this.value = value;
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
    }
}
