package com.mijiaokj.sys.dal.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mijiaokj.sys.domain.RoleControlRelation;

import java.util.List;

/**
 * 
 * @ClassName: RoleControlRelationMapper
 * @Description: TODO 角色权限表Mapper
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月14日
 *
 */
@Mapper
public interface RoleControlRelationMapper extends BaseMapper<RoleControlRelation> {

    /**
     * 通过角色id获取角色权限关系
     * @param roleId
     * @return
     */
    List<RoleControlRelation> getRoleControlRelationByRoleId(Long roleId);
}