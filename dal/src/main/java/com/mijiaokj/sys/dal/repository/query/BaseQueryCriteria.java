package com.mijiaokj.sys.dal.repository.query;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * 
 * @ClassName: BaseQueryCriteria
 * @Description: TODO 基础查询条件Criteria
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月14日
 *
 */
public class BaseQueryCriteria {
	/**
     * 默认每页为10条数据
     */
    private static final int DEFAULT_DB_PAGE_SIZE = 10;

    /**
     * 每页数量
     */
    private int pageSize;
    
    /**
     * 当前页
     */
    private int currentPage = 0;
    
    /**
     * 排序类型:0-desc,1-asc;
     */
    private int sortType;
    
    /**
     * 排序字段: 0-创建时间   1-修改时间
     */
    private int order;
    
    /**
     * 开始位置
     */
    private int startRow;
    
    /**
     * 获取开始坐标
     * @return
     */
    public int getStartRow(){
    	if(startRow>0){
    		return startRow;
    	}
        if (currentPage <= 0) {
            currentPage = 0;
        }
        if (pageSize <= 0) {
            pageSize = DEFAULT_DB_PAGE_SIZE;
        }
        Integer start = (currentPage) * pageSize;
        return start;
    }
    
    public void setStartRow(int start){
    	this.startRow=start;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

    /**
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(int order) {
        this.order = order;
    }
}
