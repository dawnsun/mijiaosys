package com.mijiaokj.sys.domain;

import java.util.Date;

import com.google.common.base.Strings;
import com.mijiaokj.sys.common.constants.BaseConstant;
/**
 * 
 * @ClassName: ReferenceObject
 * @Description: TODO 公共数据
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月14日
 *
 */
public class ReferenceObject extends BaseDomainObject {
	private Long id;
    private Date gmtCreate;
    private Date gmtModified;
    private String  creator;
    private String  modifier;
    private Boolean isDelete;

    public void setDefaultValue(){
        Date now = new Date();

        if (gmtCreate == null) {
            setGmtCreate(now);
        }
        if (gmtModified == null) {
            setGmtModified(now);
        }
        if (Strings.isNullOrEmpty(creator)) {
            setCreator(BaseConstant.SYS);
        }
        if (Strings.isNullOrEmpty(modifier)) {
            setModifier(BaseConstant.SYS);
        }
        if (isDelete == null) {
            setDelete(false);
        }
    }

    public void setDefaultValueForUpdate(){
        if (Strings.isNullOrEmpty(modifier)) {
            setCreator(BaseConstant.SYS);
        }
        if (gmtModified == null) {
            Date now = new Date();
            setGmtModified(now);
        }
        if (isDelete == null) {
            setDelete(false);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
