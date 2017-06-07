package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮件激活码信息
 * p_email_code
 */
public class EmailCodeDo implements Serializable {
    /**
     * id
     * p_email_code.id
     */
    private Integer id;

    /**
     * 创建人
     * p_email_code.created_by
     */
    private Integer createdBy;

    /**
     * 创建时间
     * p_email_code.created_dt
     */
    private Date createdDt;

    /**
     * 最后更新人
     * p_email_code.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 最后更新时间
     * p_email_code.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 状态(Y:有效;N:无效)
     * p_email_code.sts
     */
    private String sts;

    /**
     * 邮件地址
     * p_email_code.email
     */
    private String email;

    /**
     * 激活码
     * p_email_code.code
     */
    private String code;

    /**
     * 激活状态 Y激活  N未激活
     * p_email_code.actived
     */
    private String actived;

    /**
     * 失效时间
     * p_email_code.expire_date
     */
    private Date expireDate;

    /**
     * 发送次数
     * p_email_code.send_num
     */
    private Integer sendNum;

    /**
     * 最近发送时间
     * p_email_code.recent_send_date
     */
    private Date recentSendDate;

    /**
     * 码类型 0 注册激活码 1找回密码
     * p_email_code.type
     */
    private String type;

    /**
     * p_email_code
     */
    private static final long serialVersionUID = 1L;

    /**
     * p_email_code.id
     * @return the value of p_email_code.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * p_email_code.id
     * @param id the value for p_email_code.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * p_email_code.created_by
     * @return the value of p_email_code.created_by
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * p_email_code.created_by
     * @param createdBy the value for p_email_code.created_by
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * p_email_code.created_dt
     * @return the value of p_email_code.created_dt
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * p_email_code.created_dt
     * @param createdDt the value for p_email_code.created_dt
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * p_email_code.last_update_by
     * @return the value of p_email_code.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * p_email_code.last_update_by
     * @param lastUpdateBy the value for p_email_code.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * p_email_code.last_update_dt
     * @return the value of p_email_code.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * p_email_code.last_update_dt
     * @param lastUpdateDt the value for p_email_code.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * p_email_code.sts
     * @return the value of p_email_code.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * p_email_code.sts
     * @param sts the value for p_email_code.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * p_email_code.email
     * @return the value of p_email_code.email
     */
    public String getEmail() {
        return email;
    }

    /**
     * p_email_code.email
     * @param email the value for p_email_code.email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * p_email_code.code
     * @return the value of p_email_code.code
     */
    public String getCode() {
        return code;
    }

    /**
     * p_email_code.code
     * @param code the value for p_email_code.code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * p_email_code.actived
     * @return the value of p_email_code.actived
     */
    public String getActived() {
        return actived;
    }

    /**
     * p_email_code.actived
     * @param actived the value for p_email_code.actived
     */
    public void setActived(String actived) {
        this.actived = actived == null ? null : actived.trim();
    }

    /**
     * p_email_code.expire_date
     * @return the value of p_email_code.expire_date
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * p_email_code.expire_date
     * @param expireDate the value for p_email_code.expire_date
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * p_email_code.send_num
     * @return the value of p_email_code.send_num
     */
    public Integer getSendNum() {
        return sendNum;
    }

    /**
     * p_email_code.send_num
     * @param sendNum the value for p_email_code.send_num
     */
    public void setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
    }

    /**
     * p_email_code.recent_send_date
     * @return the value of p_email_code.recent_send_date
     */
    public Date getRecentSendDate() {
        return recentSendDate;
    }

    /**
     * p_email_code.recent_send_date
     * @param recentSendDate the value for p_email_code.recent_send_date
     */
    public void setRecentSendDate(Date recentSendDate) {
        this.recentSendDate = recentSendDate;
    }

    /**
     * p_email_code.type
     * @return the value of p_email_code.type
     */
    public String getType() {
        return type;
    }

    /**
     * p_email_code.type
     * @param type the value for p_email_code.type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * p_email_code
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        EmailCodeDo other = (EmailCodeDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getCreatedDt() == null ? other.getCreatedDt() == null : this.getCreatedDt().equals(other.getCreatedDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getActived() == null ? other.getActived() == null : this.getActived().equals(other.getActived()))
            && (this.getExpireDate() == null ? other.getExpireDate() == null : this.getExpireDate().equals(other.getExpireDate()))
            && (this.getSendNum() == null ? other.getSendNum() == null : this.getSendNum().equals(other.getSendNum()))
            && (this.getRecentSendDate() == null ? other.getRecentSendDate() == null : this.getRecentSendDate().equals(other.getRecentSendDate()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    /**
     * p_email_code
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getCreatedDt() == null) ? 0 : getCreatedDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getActived() == null) ? 0 : getActived().hashCode());
        result = prime * result + ((getExpireDate() == null) ? 0 : getExpireDate().hashCode());
        result = prime * result + ((getSendNum() == null) ? 0 : getSendNum().hashCode());
        result = prime * result + ((getRecentSendDate() == null) ? 0 : getRecentSendDate().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }
}