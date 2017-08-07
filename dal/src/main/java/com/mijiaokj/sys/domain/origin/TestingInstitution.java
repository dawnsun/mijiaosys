package com.mijiaokj.sys.domain.origin;

import com.mijiaokj.sys.domain.ReferenceObject;

/**
 *
 * @ClassName: SysUser
 * @Description: TODO 检测机构表
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年08月07日
 * institution_name            varchar(64) not null comment '检测机构名称',
 * institution_address         varchar(32) not null comment '检测机构地址',
 * institution_contacts        varchar(32) not null comment '检测机构联系人',
 * institution_phone           varchar(16) not null comment '检测机构电话',
 * */
public class TestingInstitution extends ReferenceObject {
    private String institutionName;
    private String institutionAddress;
    private String institutionContacts;
    private String institutionPhone;

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public String getInstitutionContacts() {
        return institutionContacts;
    }

    public void setInstitutionContacts(String institutionContacts) {
        this.institutionContacts = institutionContacts;
    }

    public String getInstitutionPhone() {
        return institutionPhone;
    }

    public void setInstitutionPhone(String institutionPhone) {
        this.institutionPhone = institutionPhone;
    }
}
