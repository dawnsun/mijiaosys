package com.mijiaokj.sys.domain.origin;

import com.mijiaokj.sys.domain.ReferenceObject;

/**
 *
 * @ClassName: SysUser
 * @Description: TODO 农作物表
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年08月07日
 * 农作物基础信息维护
 * crops_name            varchar(64) not null comment '农作物名称',
 * crops_icon            varchar(32) not null comment '农作物图标',
 * parent_id            bigint(20) unsigned not null comment '父农作物ID',
 * crops_order           int(10) not null comment '农作物排序',
 * */
public class Crops extends ReferenceObject {
    private String cropsName;
    private String cropsIcon;
    private Long parentId;
    private Integer cropsOrder;

    public String getCropsName() {
        return cropsName;
    }

    public void setCropsName(String cropsName) {
        this.cropsName = cropsName;
    }

    public String getCropsIcon() {
        return cropsIcon;
    }

    public void setCropsIcon(String cropsIcon) {
        this.cropsIcon = cropsIcon;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getCropsOrder() {
        return cropsOrder;
    }

    public void setCropsOrder(Integer cropsOrder) {
        this.cropsOrder = cropsOrder;
    }
}
