package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by wyh on 2016/12/21.
 */
public class PrintParamPo implements Serializable{
    //@NotNull(message = "原产地不能为空!")
    private String madeAddress; //原产地
    //@NotNull(message = "打印尺寸不能为空!")
    private String labelSize; //打印尺寸
    @NotNull(message = "{crm.printparam.check.id.notnull}")
    private String id;// 上传的文件ID

    public String getMadeAddress() {
        return madeAddress;
    }

    public void setMadeAddress(String madeAddress) {
        this.madeAddress = madeAddress;
    }

    public String getLabelSize() {
        return labelSize;
    }

    public void setLabelSize(String labelSize) {
        this.labelSize = labelSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
