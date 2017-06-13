package com.mijiaokj.sys.dal.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mijiaokj.sys.domain.RoleMenuRelation;

import java.util.List;

/**
 * 
 * @ClassName: RoleMenuRelationMapper
 * @Description: TODO 角色资源关系Mapper
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月14日
 *
 */
@Mapper
public interface RoleMenuRelationMapper extends BaseMapper<RoleMenuRelation> {

    /**
     * 通过角色主键查询关联的菜单
     * @param roleId
     * @return
     */
    List<RoleMenuRelation> getRoleMenuRelationByRoleId(Long roleId);

    /**
     * 批量插入关联关系
     * @param roleMenuRelationList
     * @return
     */
    Long insertByBatch(List<RoleMenuRelation> roleMenuRelationList);
}