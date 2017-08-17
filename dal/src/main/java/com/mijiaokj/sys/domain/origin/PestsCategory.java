package com.mijiaokj.sys.domain.origin;

import com.mijiaokj.sys.domain.ReferenceObject;

/**
 * Created by Administrator on 2017/8/15.
 * 病虫害类目表
 * pests_name            varchar(64) not null comment '病虫害类目名称',
 * pests_icon            varchar(32) not null comment '病虫害类目图标',
 * parent_id            bigint(20) unsigned not null comment '父病虫害类目ID',
 * pests_order           int(10) not null comment '病虫害类目排序',
 */
public class PestsCategory extends ReferenceObject {
    private String pestsName;
    private String getPestsIcon;
    private Long parentId;
    private Integer pestsOrder;

    public String getPestsName() {
        return pestsName;
    }

    public void setPestsName(String pestsName) {
        this.pestsName = pestsName;
    }

    public String getGetPestsIcon() {
        return getPestsIcon;
    }

    public void setGetPestsIcon(String getPestsIcon) {
        this.getPestsIcon = getPestsIcon;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getPestsOrder() {
        return pestsOrder;
    }

    public void setPestsOrder(Integer pestsOrder) {
        this.pestsOrder = pestsOrder;
    }
}
