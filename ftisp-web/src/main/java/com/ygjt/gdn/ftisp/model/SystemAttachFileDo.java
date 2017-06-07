package com.ygjt.gdn.ftisp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 平台公共文件表
 * p_system_attach_file
 */
public class SystemAttachFileDo implements Serializable {
    /**
     * ID
     * p_system_attach_file.id
     */
    private Integer id;

    /**
     * 所属对象
     * p_system_attach_file.object_id
     */
    private Integer objectId;

    /**
     * 对象类型
     * p_system_attach_file.object_type
     */
    private String objectType;

    /**
     * 文件名称
     * p_system_attach_file.file_name
     */
    private String fileName;

    /**
     * 文件类型
     * p_system_attach_file.file_type
     */
    private String fileType;

    /**
     * 文件大小
     * p_system_attach_file.file_size
     */
    private Double fileSize;

    /**
     * 文件路径
     * p_system_attach_file.file_path
     */
    private String filePath;

    /**
     * 文件上传名称
     * p_system_attach_file.file_real_name
     */
    private String fileRealName;

    /**
     * 文件备注
     * p_system_attach_file.file_memo
     */
    private String fileMemo;

    /**
     * 创建时间
     * p_system_attach_file.create_dt
     */
    private Date createDt;

    /**
     * 创建人
     * p_system_attach_file.create_by
     */
    private Integer createBy;

    /**
     * 最后更新时间
     * p_system_attach_file.last_update_dt
     */
    private Date lastUpdateDt;

    /**
     * 最后更新人
     * p_system_attach_file.last_update_by
     */
    private Integer lastUpdateBy;

    /**
     * 状态
     * p_system_attach_file.sts
     */
    private String sts;

    /**
     * p_system_attach_file
     */
    private static final long serialVersionUID = 1L;

    /**
     * p_system_attach_file.id
     * @return the value of p_system_attach_file.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * p_system_attach_file.id
     * @param id the value for p_system_attach_file.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * p_system_attach_file.object_id
     * @return the value of p_system_attach_file.object_id
     */
    public Integer getObjectId() {
        return objectId;
    }

    /**
     * p_system_attach_file.object_id
     * @param objectId the value for p_system_attach_file.object_id
     */
    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    /**
     * p_system_attach_file.object_type
     * @return the value of p_system_attach_file.object_type
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * p_system_attach_file.object_type
     * @param objectType the value for p_system_attach_file.object_type
     */
    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
    }

    /**
     * p_system_attach_file.file_name
     * @return the value of p_system_attach_file.file_name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * p_system_attach_file.file_name
     * @param fileName the value for p_system_attach_file.file_name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * p_system_attach_file.file_type
     * @return the value of p_system_attach_file.file_type
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * p_system_attach_file.file_type
     * @param fileType the value for p_system_attach_file.file_type
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * p_system_attach_file.file_size
     * @return the value of p_system_attach_file.file_size
     */
    public Double getFileSize() {
        return fileSize;
    }

    /**
     * p_system_attach_file.file_size
     * @param fileSize the value for p_system_attach_file.file_size
     */
    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * p_system_attach_file.file_path
     * @return the value of p_system_attach_file.file_path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * p_system_attach_file.file_path
     * @param filePath the value for p_system_attach_file.file_path
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * p_system_attach_file.file_real_name
     * @return the value of p_system_attach_file.file_real_name
     */
    public String getFileRealName() {
        return fileRealName;
    }

    /**
     * p_system_attach_file.file_real_name
     * @param fileRealName the value for p_system_attach_file.file_real_name
     */
    public void setFileRealName(String fileRealName) {
        this.fileRealName = fileRealName == null ? null : fileRealName.trim();
    }

    /**
     * p_system_attach_file.file_memo
     * @return the value of p_system_attach_file.file_memo
     */
    public String getFileMemo() {
        return fileMemo;
    }

    /**
     * p_system_attach_file.file_memo
     * @param fileMemo the value for p_system_attach_file.file_memo
     */
    public void setFileMemo(String fileMemo) {
        this.fileMemo = fileMemo == null ? null : fileMemo.trim();
    }

    /**
     * p_system_attach_file.create_dt
     * @return the value of p_system_attach_file.create_dt
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * p_system_attach_file.create_dt
     * @param createDt the value for p_system_attach_file.create_dt
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * p_system_attach_file.create_by
     * @return the value of p_system_attach_file.create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * p_system_attach_file.create_by
     * @param createBy the value for p_system_attach_file.create_by
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * p_system_attach_file.last_update_dt
     * @return the value of p_system_attach_file.last_update_dt
     */
    public Date getLastUpdateDt() {
        return lastUpdateDt;
    }

    /**
     * p_system_attach_file.last_update_dt
     * @param lastUpdateDt the value for p_system_attach_file.last_update_dt
     */
    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    /**
     * p_system_attach_file.last_update_by
     * @return the value of p_system_attach_file.last_update_by
     */
    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * p_system_attach_file.last_update_by
     * @param lastUpdateBy the value for p_system_attach_file.last_update_by
     */
    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * p_system_attach_file.sts
     * @return the value of p_system_attach_file.sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * p_system_attach_file.sts
     * @param sts the value for p_system_attach_file.sts
     */
    public void setSts(String sts) {
        this.sts = sts == null ? null : sts.trim();
    }

    /**
     * p_system_attach_file
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
        SystemAttachFileDo other = (SystemAttachFileDo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getObjectType() == null ? other.getObjectType() == null : this.getObjectType().equals(other.getObjectType()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getFileType() == null ? other.getFileType() == null : this.getFileType().equals(other.getFileType()))
            && (this.getFileSize() == null ? other.getFileSize() == null : this.getFileSize().equals(other.getFileSize()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
            && (this.getFileRealName() == null ? other.getFileRealName() == null : this.getFileRealName().equals(other.getFileRealName()))
            && (this.getFileMemo() == null ? other.getFileMemo() == null : this.getFileMemo().equals(other.getFileMemo()))
            && (this.getCreateDt() == null ? other.getCreateDt() == null : this.getCreateDt().equals(other.getCreateDt()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getLastUpdateDt() == null ? other.getLastUpdateDt() == null : this.getLastUpdateDt().equals(other.getLastUpdateDt()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getSts() == null ? other.getSts() == null : this.getSts().equals(other.getSts()));
    }

    /**
     * p_system_attach_file
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getObjectType() == null) ? 0 : getObjectType().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFileType() == null) ? 0 : getFileType().hashCode());
        result = prime * result + ((getFileSize() == null) ? 0 : getFileSize().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getFileRealName() == null) ? 0 : getFileRealName().hashCode());
        result = prime * result + ((getFileMemo() == null) ? 0 : getFileMemo().hashCode());
        result = prime * result + ((getCreateDt() == null) ? 0 : getCreateDt().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getLastUpdateDt() == null) ? 0 : getLastUpdateDt().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getSts() == null) ? 0 : getSts().hashCode());
        return result;
    }
}