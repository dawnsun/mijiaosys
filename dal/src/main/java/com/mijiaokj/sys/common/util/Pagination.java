package com.mijiaokj.sys.common.util;

import java.io.Serializable;

/**
 * Created by sunchenguang on 2017/5/31.
 */
public class Pagination implements Serializable {
    /***
     * 对外的页数是1
     */

    /**分页索引,当期的页*/
    protected int pageIndex = 1;

    /**每页记录条数*/
    protected int pageSize = 50;

    /**总记录数*/
    protected int totalCount = 0;

    /**当前页条数*/
    protected int currentPageCount = 0;

    protected int totalPage = -1;

    /**手动指定start*/
    protected Long start = null;

    public int getTotalPage() {
        totalPage = (totalCount + pageSize -1)/pageSize;

        return totalPage;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if(pageIndex<0){
            this.pageIndex=1;
        }else{
            this.pageIndex = pageIndex;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if(pageSize<0){
            pageSize = 20;
        }else{
            this.pageSize = pageSize;
        }

    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPageCount(){
        return currentPageCount;
    }

    /**
     * 是否还有更多记录
     * @return
     */
    public boolean hasMorePages() {

        boolean result = false;

        if(pageIndex != 0){
            result = (pageIndex) < getTotalPage();
        }

        return result;

    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public long getStartRow() {
        return getPageSize() * (getPageIndex() - 1);
    }
}
