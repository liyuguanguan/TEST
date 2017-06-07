package com.ygjt.gdn.ftisp.model.vo;


import com.ygjt.gdn.ftisp.common.IVO;

/**
 * Created by zzy on 2016/11/2.
 */
public class AreaVO implements IVO{
    /**
     * ID
     * p_area.id
     */
    private Integer id;

    /**
     * 地区编码
     * p_area.code
     */
    private String code;

    /**
     * 地区中文名称
     * p_area.name
     */
    private String name;

    /**
     * 地区英文名称
     * p_area.name_en
     */
    private String nameEn;

    /**
     * 层级
     * p_area.level
     */
    private Integer level;

    /**
     * 父级
     * p_area.parent_id
     */
    private Integer parentId;

    /**
     * 国家二字码
     * p_area.code_two
     */
    private String codeTwo;

    /**
     * 国家三字码
     * p_area.code_three
     */
    private String codeThree;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCodeTwo() {
        return codeTwo;
    }

    public void setCodeTwo(String codeTwo) {
        this.codeTwo = codeTwo;
    }

    public String getCodeThree() {
        return codeThree;
    }

    public void setCodeThree(String codeThree) {
        this.codeThree = codeThree;
    }
}
