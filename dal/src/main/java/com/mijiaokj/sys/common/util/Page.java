package com.mijiaokj.sys.common.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: Page
 * @Description: TODO 分页工具类 
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月13日
 *
 */
public class Page<E> implements Serializable {
    
    private static final long serialVersionUID = 1043141558460231519L;

    public static final int DEFAULT_DB_PAGE_SIZE = 10;

    public Page(){

    }

    public Page(Integer pageIndex){
        this.pageIndex = pageIndex;

    }

    public Page(Integer start, Integer pageSize){
        this.start = start;
        this.pageSize = pageSize;
    }

    /**
     * 查询的开始记录数
     */
    private Integer start = 0;

    /**
     * 当前的页码
     */
    private Integer pageIndex = 0;

    /**
     * 每页记录数
     */
    private Integer pageSize = 10;

    /**
     * 总的页码
     */
    private Integer pageCount = 0;

    /**
     * 记录总数
     */
    private Integer recordCount = 0;

    /**
     * 数据内容
     */
    private List<E> datas;

    /**
     * 内存分页
     * 
     * @param list 包含所有记录的列表
     * @param pageIndex 页码
     * @param pageSize 每页大小
     */
    public Page(Integer pageIndex, Integer pageSize, List<E> list){
        if (list == null || list.size() == 0) {
            this.setDatas(new ArrayList<E>(0));
            this.setStart(0);
        } else {
            // 默认分页
            if (pageIndex == null || pageIndex < 0) {
                pageIndex = 0;
            }
            if (pageSize == null || pageSize <= 0) {
                pageSize = 10;
            }

            int recordCount = list.size();
            int pageCount = 0;
            if (recordCount % pageSize == 0) {
                pageCount = recordCount / pageSize;
            } else {
                pageCount = (recordCount / pageSize) + 1;
            }

            if (pageIndex + 1 > pageCount) {
                pageIndex = pageCount - 1;
            }

            this.setPageIndex(pageIndex);
            this.setPageSize(pageSize);
            this.setPageCount(pageCount);
            this.setRecordCount(recordCount);
            this.setStart(pageIndex * pageSize);
            List<E> subList = new ArrayList<E>(
                                               list.subList(pageIndex * pageSize,
                                                            (pageIndex + 1) * pageSize > recordCount ? recordCount : (pageIndex + 1)
                                                                                                                     * pageSize));
            this.setDatas(subList);
        }
    }

    /**
     * 数据库分页
     * 
     * @param datas
     * @param start
     * @param pageSize
     * @param recordCount
     */
    public Page(List<E> datas, Integer start, Integer pageSize, Integer recordCount){
        super();
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }

        int pageCount = 0;
        if (recordCount % pageSize == 0) {
            pageCount = recordCount / pageSize;
        } else {
            pageCount = (recordCount / pageSize) + 1;
        }
        this.start = start;
        this.pageIndex = start / pageSize;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.recordCount = recordCount;
        this.datas = datas;
    }

    public static Integer getStartIndex(Integer currentPage, Integer pageSize) {
        if (currentPage == null || currentPage <= 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = DEFAULT_DB_PAGE_SIZE;
        }
        Integer start = (currentPage - 1) * pageSize;
        return start;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public List<E> getDatas() {
        return datas;
    }

    public void setDatas(List<E> datas) {
        this.datas = datas;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"start\":\"");
        builder.append(start);
        builder.append("\", \"pageIndex\":\"");
        builder.append(pageIndex);
        builder.append("\", \"pageSize\":\"");
        builder.append(pageSize);
        builder.append("\", \"pageCount\":\"");
        builder.append(pageCount);
        builder.append("\", \"recordCount\":\"");
        builder.append(recordCount);
        builder.append("\", \"datas\":");
        builder.append(datas);
        builder.append("}");
        return builder.toString();
    }

    
}