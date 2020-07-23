package com.li.util;

import java.util.List;

/**
 * 分页
 */
public class Page<T> {

    private Integer pageNum;  // 页码
    private Integer pageSize;  // 页面大小
    private Integer startRow;  // 开始行
    private Integer endRow;  // 结束行
    private Integer total;  // 总数
    private Object filter;  // 过滤条件
    private List<T> data;  // 数据

    public Page(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartRow() {
        if( startRow != null)
            return startRow;
        if(pageNum > 0)
            return (pageNum - 1) * pageSize;
        return 0;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        return (pageNum < 1 ? 1 : pageNum) * pageSize;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Object getFilter() {
        return filter;
    }

    public void setFilter(Object filter) {
        this.filter = filter;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
