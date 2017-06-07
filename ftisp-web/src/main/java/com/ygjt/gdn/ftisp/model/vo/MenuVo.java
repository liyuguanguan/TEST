package com.ygjt.gdn.ftisp.model.vo;

import java.util.List;

/**
 * 菜单集合
 * Created by linx on 2016/11/4.
 */
public class MenuVo {
    private Integer id;
    private String moduleName;
    private String icon;
    private Integer priority;
    private List<MenuVo> childs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public List<MenuVo> getChilds() {
        return childs;
    }

    public void setChilds(List<MenuVo> childs) {
        this.childs = childs;
    }
}
