package com.mijiaokj.sys.service.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.RoleMenuRelationRepository;
import com.mijiaokj.sys.domain.RoleControlRelation;
import com.mijiaokj.sys.domain.RoleMenuRelation;
import com.mijiaokj.sys.service.RoleMenuRelationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 * 角色与菜单的关联关系
 * 通过角色id找当前角色所有的菜单操作
 */
@Service("roleMenuRelationService")
public class RoleMenuRelationServiceImpl implements RoleMenuRelationService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private RoleMenuRelationRepository roleMenuRelationRepository;
    @Override
    public Result<List<RoleMenuRelation>> getRoleMenuRelationByRoleId(Long roleId) {
        try {
            List<RoleMenuRelation> l = roleMenuRelationRepository.getRoleMenuRelationByRoleId(roleId);
            return Result.ofSuccess(l);
        } catch (Exception e) {
            logger.error("getRoleMenuRelationByRoleId " + e);
            return Result.ofFail("getRoleMenuRelationByRoleId fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Long> createRoleMenuRelationByBatch(List<RoleMenuRelation> roleMenuRelationList) {
        try {
            Preconditions.checkNotNull(roleMenuRelationList);
            return Result.ofSuccess(roleMenuRelationRepository.createRoleMenuRelationByBatch(roleMenuRelationList));
        } catch (Exception e) {
            logger.error("createRoleMenuRelationByBatch " + e);
            return Result.ofFail("createRoleMenuRelationByBatch fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> deleteRoleMenuRelation(Long id) {
        try {
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(roleMenuRelationRepository.delete(id));
        } catch (Exception e) {
            logger.error("deleteRoleMenuRelation " + e);
            return Result.ofFail("deleteRoleMenuRelation fail:" + e.getMessage());
        }
    }
}
