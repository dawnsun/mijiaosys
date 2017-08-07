package com.mijiaokj.sys.domain.origin;

import com.mijiaokj.sys.domain.ReferenceObject;

/**
 *
 * @ClassName: SysUser
 * @Description: TODO 季度土地作物表
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年08月07日
 * year              varchar(8) comment '年份',
 * quarter        varchar(16)  comment '季度份',
 * land_id     bigint(20) unsigned not null comment '土地id',
 * user_id     bigint(20) unsigned not null  comment '管理者id',
 * crops_id     bigint(20) unsigned not null comment '作物id',
 * crops_no           varchar(16) comment '作物数量',
 */
public class QuarterLandCrops extends ReferenceObject {
    private String year;
    private String quarter;
    private Long landId;
    private Long userId;
    private Long cropsId;
    private String cropsNo;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public Long getLandId() {
        return landId;
    }

    public void setLandId(Long landId) {
        this.landId = landId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCropsId() {
        return cropsId;
    }

    public void setCropsId(Long cropsId) {
        this.cropsId = cropsId;
    }

    public String getCropsNo() {
        return cropsNo;
    }

    public void setCropsNo(String cropsNo) {
        this.cropsNo = cropsNo;
    }
}
