package com.ygjt.gdn.ftisp.model.vo;

import java.util.List;

/**
 * Created by zhongb on 2017/4/25.
 */
public class GoodMoreDetailVo extends GoodDetailVo{
    private String [] keywords;
    private List<Pics> pics;


    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public List<Pics> getPics() {
        return pics;
    }

    public void setPics(List<Pics> pics) {
        this.pics = pics;
    }
}
