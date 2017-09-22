package com.mijiaokj.sys.dal.repository.query.origin;

import com.mijiaokj.sys.dal.repository.query.BaseQueryCriteria;

/**
 * Created by wb-scg178938 on 2017/9/22.
 * 作物日常操作查询条件
 * '土地id', '作物id', '管理者id','操作id','是否发现病虫害 0-无 1-有','病虫害备注','操作备注'
 */
public class DailyOperationCriteria extends BaseQueryCriteria {
    private Long landId;
    private Long cropsId;
    private Long userId;
    private Long operationId;
    private Boolean isPests;
    private String pestsRemarks;
    private String operationRemarks;

    public Long getLandId() {
        return landId;
    }

    public void setLandId(Long landId) {
        this.landId = landId;
    }

    public Long getCropsId() {
        return cropsId;
    }

    public void setCropsId(Long cropsId) {
        this.cropsId = cropsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Boolean getPests() {
        return isPests;
    }

    public void setPests(Boolean pests) {
        isPests = pests;
    }

    public String getPestsRemarks() {
        return pestsRemarks;
    }

    public void setPestsRemarks(String pestsRemarks) {
        this.pestsRemarks = pestsRemarks;
    }

    public String getOperationRemarks() {
        return operationRemarks;
    }

    public void setOperationRemarks(String operationRemarks) {
        this.operationRemarks = operationRemarks;
    }
}
