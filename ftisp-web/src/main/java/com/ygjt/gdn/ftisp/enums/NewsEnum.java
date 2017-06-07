package com.ygjt.gdn.ftisp.enums;

/**
 * Created by ZZY on 2016/8/30.
 */
public class NewsEnum {
    public enum NEWS_TYPE {
        PLATFORM_NEWS(1,"平台公告"),
        DYNAMIC_NEWS(2,"平台动态"),
        INDUSTRY_NEWS(3,"行业动态"),
        KNOWLEDGE_BASE(4,"行业知识库"),
        REGULATION(5,"政策法规"),
        SYSTEM_NOTICE(6,"系统公告"),
        SERVICE_CENTER(7,"服务中心"),
        FAQ(8,"常见问题"),
        COOPERATION_PROCESS(9,"合作流程"),
        CONSULT_VIDEO(10,"咨询与视频")
        ;

        private int value;
        private String name;

        NEWS_TYPE( int value,String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static NEWS_TYPE parse(int value) {
            for (NEWS_TYPE type : NEWS_TYPE.values()) {
                if (type.value == value) {
                    return type;
                }
            }
            return null;
        }
    }

    public enum NEWS_STAT {
        RELEASED("1","已发布"),
        NOTRELEASED("2","未发布"),
        DELETED("0","已删除");

        private String value;
        private String name;

        NEWS_STAT( String value,String name) {
            this.name = name;
            this.value = value;
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

        public static NEWS_STAT parse(String value) {
            for (NEWS_STAT stat : NEWS_STAT.values()) {
                if (stat.value.equals(value)) {
                    return stat;
                }
            }
            return null;
        }
    }

    public enum NEWS_IS_HEAD {
        IS_HEAD(1,"头条"),
        NOT_HEAD(0,"普通");

        private int value;
        private String name;

        NEWS_IS_HEAD( int value,String name) {
            this.name = name;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static NEWS_IS_HEAD parse(int value) {
            for (NEWS_IS_HEAD head : NEWS_IS_HEAD.values()) {
                if (head.value == (value)) {
                    return head;
                }
            }
            return null;
        }
    }

    public enum CATEGORY {
        NEWS("1","新闻"),
        HELPER("2","服务与帮助"),
        REGULATION("3","政策法规"),
        SYSTEM_NOTICE("4","系统公告")
        ;

        private String value;
        private String name;

        CATEGORY( String value,String name) {
            this.name = name;
            this.value = value;
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

        public static CATEGORY parse(int value) {
            for (CATEGORY head : CATEGORY.values()) {
                if (head.value.equals(value)) {
                    return head;
                }
            }
            return null;
        }
    }
}
