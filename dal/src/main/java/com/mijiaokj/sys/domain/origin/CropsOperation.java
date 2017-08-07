package com.mijiaokj.sys.domain.origin;

import com.mijiaokj.sys.domain.ReferenceObject;

/**
 *
 * @ClassName: CropsOperation
 * @Description: TODO 作物操作配置表
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年08月07日
 * operation_name              varchar(256) comment '操作名称',
 * crops_id     bigint(20) unsigned not null comment '作物id',
 * is_main_operation     tinyint(1) not null DEFAULT '0' comment '是否重点操作 0-否 1-是',
 * main_option_table      varchar(256)  comment '重点操作关联表名（农药喷洒，施肥）',
 * operation_order           int(10) not null comment '操作排序',
 * */
public class CropsOperation extends ReferenceObject {
    private Long cropsId;
    private String operationName;
    private Boolean isMainOperation;
    private String mainOptionTable;
    private Integer operationOrder;

    public Long getCropsId() {
        return cropsId;
    }

    public void setCropsId(Long cropsId) {
        this.cropsId = cropsId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Boolean getMainOperation() {
        return isMainOperation;
    }

    public void setMainOperation(Boolean mainOperation) {
        isMainOperation = mainOperation;
    }

    public String getMainOptionTable() {
        return mainOptionTable;
    }

    public void setMainOptionTable(String mainOptionTable) {
        this.mainOptionTable = mainOptionTable;
    }

    public Integer getOperationOrder() {
        return operationOrder;
    }

    public void setOperationOrder(Integer operationOrder) {
        this.operationOrder = operationOrder;
    }
}
