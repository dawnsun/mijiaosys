package com.mijiaokj.sys.web.response;

/**
 * Created by sunchenguang on 2017/5/31.
 */
public class PagingVO extends BaseModelView {
    /*@FieldSetting(
            title = "对象类型",
            description = "对象的类型，此处值只有 paging"
    )*/
    private String type = "paging";
   /* @FieldSetting(
            title = "每页条目",
            description = "控制每一页最多展示多少条数据"
    )*/
    /*@ValidatorInt(
            minimum = 0
    )*/
    private int pageSize = 10;
   /* @FieldSetting(
            title = "当前页显示的条目",
            description = "当前页显示的条目"
    )
    @ValidatorInt(
            minimum = 0
    )*/
    private int currentPageSize = 10;
    /*@FieldSetting(
            title = "当前页数据第一条的索引",
            description = "paging.items中第一个条目的索引"
    )
    @ValidatorInt(
            minimum = 0
    )*/
    private int start = 0;
   /* @FieldSetting(
            title = "总条目数",
            description = "当前集合中可用的总条目数"
    )
    @ValidatorInt(
            minimum = 0
    )*/
    private int totalItems;
    /*@FieldSetting(
            title = "当前页码",
            description = "从0开始计数"
    )
    @ValidatorInt(
            minimum = 0
    )*/
    private int currentPage = 0;
   /* @FieldSetting(
            title = "总页数",
            description = "总页数，从1开始计数"
    )
    @ValidatorInt(
            minimum = 0
    )*/
    private int totalPages=0;

    public PagingVO() {
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPageSize() {
        return this.currentPageSize;
    }

    public void setCurrentPageSize(int currentPageSize) {
        this.currentPageSize = currentPageSize;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalItems() {
        return this.totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}