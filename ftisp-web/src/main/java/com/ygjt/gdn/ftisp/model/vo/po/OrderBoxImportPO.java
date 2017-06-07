package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.utils.excel.Excel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * 订单包裹批量导入PO
 * Created by linx on 2016/11/3.
 */
public class OrderBoxImportPO {
    private Integer toWarehouseId;
    private List<OrderBoxPO> boxList;

    public Integer getToWarehouseId() {
        return toWarehouseId;
    }

    public void setToWarehouseId(Integer toWarehouseId) {
        this.toWarehouseId = toWarehouseId;
    }

    public List<OrderBoxPO> getBoxList() {
        return boxList;
    }

    public void setBoxList(List<OrderBoxPO> boxList) {
        this.boxList = boxList;
    }
}
