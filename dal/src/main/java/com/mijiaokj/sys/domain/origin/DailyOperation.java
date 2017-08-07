package com.mijiaokj.sys.domain.origin;

import com.mijiaokj.sys.domain.ReferenceObject;

/**
 * Created by Administrator on 2017/8/7.
 *  land_id     bigint(20) unsigned not null comment '土地id',
 crops_id     bigint(20) unsigned not null comment '作物id',
 user_id     bigint(20) unsigned not null  comment '管理者id',
 operation_id     bigint(20) unsigned not null comment '操作id',
 is_pests     tinyint(1) not null DEFAULT '0' comment '是否发现病虫害 0-无 1-有',
 operation_photo    varchar(1024) comment '操作照片',
 pests_remarks     varchar(1024)  comment '病虫害备注',
 operation_remarks     varchar(1024)  comment '操作备注',
 extended           varchar(2000)  comment '扩展字段，key-velue存储扩展操作（农药，施肥等重点操作）',
 */
public class DailyOperation extends ReferenceObject {
    private Long landId;
    private Long cropsId;
    private Long userId;
    private Long operationId;
    private Boolean isPests;
    private String operationPhoto;
    private String pestsRemarks;
    private String operationRemarks;
    private String extended;

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

    public String getOperationPhoto() {
        return operationPhoto;
    }

    public void setOperationPhoto(String operationPhoto) {
        this.operationPhoto = operationPhoto;
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

    public String getExtended() {
        return extended;
    }

    public void setExtended(String extended) {
        this.extended = extended;
    }
}
