package com.mijiaokj.sys.domain.origin;

import com.mijiaokj.sys.domain.ReferenceObject;

import java.util.Date;

/**
 *
 * @ClassName: SysUser
 * @Description: TODO 土地质量监测表
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年08月07日
 * land_id              bigint(20) unsigned not null comment '土地资源主键',
 * over_elements        varchar(16)  comment '超标元素',
 * missing_elements     varchar(16)  comment '缺失元素',
 * ph                varchar(2)  comment '酸碱度',
 * testing_id              bigint(20)  comment '检测机构id',
 * gmt_testing           datetime not null comment '监测时间',
 * testing_file                 varchar(16)  comment '检测附件',
 * land_img                 varchar(16)  comment '当前土地照片附件id多张用逗号隔开',
 * */
public class LandQuality extends ReferenceObject {
    private Long landId;
    private String overElements;
    private String missingElements;
    private String ph;
    private Long testingId;
    private Date gmtTesting;
    private String testingFile;
    private String landImg;

    public Long getLandId() {
        return landId;
    }

    public void setLandId(Long landId) {
        this.landId = landId;
    }

    public String getOverElements() {
        return overElements;
    }

    public void setOverElements(String overElements) {
        this.overElements = overElements;
    }

    public String getMissingElements() {
        return missingElements;
    }

    public void setMissingElements(String missingElements) {
        this.missingElements = missingElements;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public Long getTestingId() {
        return testingId;
    }

    public void setTestingId(Long testingId) {
        this.testingId = testingId;
    }

    public Date getGmtTesting() {
        return gmtTesting;
    }

    public void setGmtTesting(Date gmtTesting) {
        this.gmtTesting = gmtTesting;
    }

    public String getTestingFile() {
        return testingFile;
    }

    public void setTestingFile(String testingFile) {
        this.testingFile = testingFile;
    }

    public String getLandImg() {
        return landImg;
    }

    public void setLandImg(String landImg) {
        this.landImg = landImg;
    }
}
