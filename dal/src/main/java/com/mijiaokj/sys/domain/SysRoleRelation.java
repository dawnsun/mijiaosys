package com.mijiaokj.sys.domain;
/**
 * 
 * @ClassName: SysRoleRelation
 * @Description: TODO 系统角色关系表
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月14日
 *
 */
public class SysRoleRelation extends ReferenceObject {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_relation.sys_id
     *
     * @mbggenerated
     */
    private Long sysId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_relation.role_id
     *
     * @mbggenerated
     */
    private Long roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_relation.sys_id
     *
     * @return the value of sys_role_relation.sys_id
     *
     * @mbggenerated
     */
    public Long getSysId() {
        return sysId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_relation.sys_id
     *
     * @param sysId the value for sys_role_relation.sys_id
     *
     * @mbggenerated
     */
    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_relation.role_id
     *
     * @return the value of sys_role_relation.role_id
     *
     * @mbggenerated
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_relation.role_id
     *
     * @param roleId the value for sys_role_relation.role_id
     *
     * @mbggenerated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}