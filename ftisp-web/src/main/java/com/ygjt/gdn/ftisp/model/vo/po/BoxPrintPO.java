package com.ygjt.gdn.ftisp.model.vo.po;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 包裹打印参数
 * Created by linx on 2016/11/16.
 */
public class BoxPrintPO {
    private String orderNo;
    private String labelSize;
    private List<BoxPrintDetailPO> boxes;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getLabelSize() {
        return labelSize;
    }

    public void setLabelSize(String labelSize) {
        this.labelSize = labelSize;
    }

    public List<BoxPrintDetailPO> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<BoxPrintDetailPO> boxes) {
        this.boxes = boxes;
    }

    public static void main(String[] args) {
        List<BoxPrintDetailPO> boxes = new ArrayList<>();
        BoxPrintDetailPO boxPrintDetailPO = new BoxPrintDetailPO();
        boxPrintDetailPO.setId("56");
        BoxPrintDetailPO boxPrintDetailPO1 = new BoxPrintDetailPO();
        boxPrintDetailPO1.setId("55");
        boxes.add(boxPrintDetailPO);
        boxes.add(boxPrintDetailPO1);
        BoxPrintPO boxPrintPO = new BoxPrintPO();
        boxPrintPO.setOrderNo("00011611320000001");
        boxPrintPO.setBoxes(boxes);
        System.out.println(JSONObject.toJSONString(boxPrintPO));
    }
}
