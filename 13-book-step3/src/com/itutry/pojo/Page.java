package com.itutry.pojo;

import java.util.List;

public class Page<T> {
    public static final int PAGE_SIZE = 4;

    // 当前页码
    private Integer pageNo;
    // 总页码
    private Integer pageTotal;
    // 每页显示的数量
    private Integer pageSize = PAGE_SIZE;
    // 总记录数
    private Integer totalCount;
    // 当前页数据
    private List<T> items;

    private String url;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageTotal, Integer totalCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageTotal = pageTotal;
        this.totalCount = totalCount;
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        // 数据边界的有效检查
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > this.pageTotal) {
            pageNo = this.pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageTotal=" + pageTotal +
                ", totalCount=" + totalCount +
                ", items=" + items +
                '}';
    }
}
