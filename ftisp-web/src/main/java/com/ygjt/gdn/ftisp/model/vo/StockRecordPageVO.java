package com.ygjt.gdn.ftisp.model.vo;

import com.ygjt.gdn.ftisp.common.PageVO;

import java.util.List;

/**
 *
 * Created by linx on 2016/11/7.
 */
public class StockRecordPageVO<T> extends PageVO {
    private Integer inStockNums;//一般入库
    private Integer outStockNums;//销售出库

    public StockRecordPageVO(int page, int count, long total, List rows) {
        super(page, count, total, rows);
    }

    public Integer getInStockNums() {
        return inStockNums;
    }

    public void setInStockNums(Integer inStockNums) {
        this.inStockNums = inStockNums;
    }

    public Integer getOutStockNums() {
        return outStockNums;
    }

    public void setOutStockNums(Integer outStockNums) {
        this.outStockNums = outStockNums;
    }
}
