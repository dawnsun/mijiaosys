package com.mijiaokj.sys.domain.origin;

import com.mijiaokj.sys.domain.ReferenceObject;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/7.
 * 物候期表
 *  phenological_name              varchar(256) comment '物候名称',
 *   crops_id     bigint(20) unsigned not null comment '作物id',
 *   start_month_day         datetime not null  comment '开始时间',
 *   end_month_day          datetime not null  comment '结束时间',
 */
public class PhenologicalPhase extends ReferenceObject {

    private String phenologicalName;
    private Long cropsId;
    private Date startMonthDay;
    private Date endMonthDay;

    public String getPhenologicalName() {
        return phenologicalName;
    }

    public void setPhenologicalName(String phenologicalName) {
        this.phenologicalName = phenologicalName;
    }

    public Long getCropsId() {
        return cropsId;
    }

    public void setCropsId(Long cropsId) {
        this.cropsId = cropsId;
    }

    public Date getStartMonthDay() {
        return startMonthDay;
    }

    public void setStartMonthDay(Date startMonthDay) {
        this.startMonthDay = startMonthDay;
    }

    public Date getEndMonthDay() {
        return endMonthDay;
    }

    public void setEndMonthDay(Date endMonthDay) {
        this.endMonthDay = endMonthDay;
    }
}
