package com.mijiaokj.sys.service;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.RoleControlRelation;

import java.util.List;

/**
 * Created by sunchenguang on 2017/6/7.
 * 角色权限关系服务接口
 */
public interface RoleControlRelationService {
    /**
     * 通过角色id查询角色和权限的关系
     * @param roleId
     * @return
     */
    public Result<List<RoleControlRelation>> getRoleControlRelationByRoleId(Long roleId);
}
