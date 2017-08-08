package com.mijiaokj.sys.domain.origin;

import com.mijiaokj.sys.domain.ReferenceObject;

/**
 * @ClassName: PesticidesCategory
 * @Description: TODO 农药类目表
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年08月07日
 * 农药类目信息
 *  pesticides_name            varchar(64) not null comment '农药类目名称',
 *  pesticides_icon            varchar(32) not null comment '农药类目图标',
 *  parent_id            bigint(20) unsigned not null comment '父农类目ID',
 *  pesticides_order           int(10) not null comment '农药类目排序',
 */
public class PesticidesCategory extends ReferenceObject {
    private String pesticidesName;
    private String pesticidesIcon;
    private Long parentId;
    private Integer pesticidesOrder;

    public String getPesticidesName() {
        return pesticidesName;
    }

    public void setPesticidesName(String pesticidesName) {
        this.pesticidesName = pesticidesName;
    }

    public String getPesticidesIcon() {
        return pesticidesIcon;
    }

    public void setPesticidesIcon(String pesticidesIcon) {
        this.pesticidesIcon = pesticidesIcon;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getPesticidesOrder() {
        return pesticidesOrder;
    }

    public void setPesticidesOrder(Integer pesticidesOrder) {
        this.pesticidesOrder = pesticidesOrder;
    }
}
