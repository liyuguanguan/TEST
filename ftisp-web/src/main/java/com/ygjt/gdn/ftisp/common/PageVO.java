package com.ygjt.gdn.ftisp.common;

import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by yhj on 16/10/21.
 */
public class PageVO<T> implements IVO {

    private int page ;
    private int pageSize ;
    private int count ;
    private long total ;

    private List<T> rows ;

    public PageVO() {
    }

    public PageVO(List<T> rows) {
        if (rows instanceof Page) {
            Page<T> page = (Page<T>) rows;
            this.page = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.count = page.getPages();
            this.total = page.getTotal();
            this.rows=rows;
        }
        this.rows = rows;
    }

    public PageVO(int page, int count, long total) {
        this.page = page;
        this.count = count;
        this.total = total;
    }

    public PageVO(int page, int count, long total, List<T> rows) {
        this.page = page;
        this.count = count;
        this.total = total;
        this.rows = rows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
