package com.mijiaokj.sys.service;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.RoleMenuRelation;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
public interface RoleMenuRelationService {
    /**
     * 通过角色id查询角色和菜单的关系
     * @param roleId
     * @return
     */
    public Result<List<RoleMenuRelation>> getRoleMenuRelationByRoleId(Long roleId);

    /**
     * 批量插入关联关系
     * @param roleMenuRelationList
     * @return
     */
    public Result<Long> createRoleMenuRelationByBatch(List<RoleMenuRelation> roleMenuRelationList);

    /**
     * 删除关联关系
     * @param id
     * @return
     */
    public Result<Integer> deleteRoleMenuRelation(Long id);
}
