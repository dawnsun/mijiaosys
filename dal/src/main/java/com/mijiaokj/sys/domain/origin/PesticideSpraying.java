package com.mijiaokj.sys.domain.origin;

import com.mijiaokj.sys.domain.ReferenceObject;

/**
 * @ClassName: PesticideSpraying
 * @Description: TODO 农药喷洒表
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年08月07日
 * 农药喷洒信息
 * pesticides_id     bigint(20) unsigned not null comment '农药id',
 * dilution_factor     varchar(64)  not null comment '稀释倍数',
 * pesticides_no    varchar(64)  not null comment '药剂数量',
 */
public class PesticideSpraying extends ReferenceObject {
    private Long pesticidesId;
    private String dilutionFactor;
    private String pesticidesNo;

    public Long getPesticidesId() {
        return pesticidesId;
    }

    public void setPesticidesId(Long pesticidesId) {
        this.pesticidesId = pesticidesId;
    }

    public String getDilutionFactor() {
        return dilutionFactor;
    }

    public void setDilutionFactor(String dilutionFactor) {
        this.dilutionFactor = dilutionFactor;
    }

    public String getPesticidesNo() {
        return pesticidesNo;
    }

    public void setPesticidesNo(String pesticidesNo) {
        this.pesticidesNo = pesticidesNo;
    }
}
