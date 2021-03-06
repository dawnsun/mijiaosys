package com.mijiaokj.sys.service.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.RoleControlRelationRepository;
import com.mijiaokj.sys.domain.RoleControlRelation;
import com.mijiaokj.sys.service.RoleControlRelationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunchenguang on 2017/6/7.
 * 角色权限关系服务实现类
 */
@Service("roleControlRelationService")
public class RoleControlRelationServiceImpl implements RoleControlRelationService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private RoleControlRelationRepository roleControlRelationRepository;

    @Override
    public Result<List<RoleControlRelation>> getRoleControlRelationByRoleId(Long roleId) {
        try {
            List<RoleControlRelation> l = roleControlRelationRepository.getRoleControlRelationByRoleId(roleId);
            return Result.ofSuccess(l);
        } catch (Exception e) {
            logger.error("getRoleControlRelationByRoleId " + e);
            return Result.ofFail("getRoleControlRelationByRoleId fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Long> createRoleControlRelationByBatch(List<RoleControlRelation> roleControlRelationList) {
        try {
            Preconditions.checkNotNull(roleControlRelationList);
            return Result.ofSuccess(roleControlRelationRepository.createRoleControlRelationByBatch(roleControlRelationList));
        } catch (Exception e) {
            logger.error("createRoleControlRelationByBatch " + e);
            return Result.ofFail("createRoleControlRelationByBatch fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> deleteRoleControlRelation(Long id) {
        try {
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(roleControlRelationRepository.delete(id));
        } catch (Exception e) {
            logger.error("deleteRoleControlRelation " + e);
            return Result.ofFail("deleteRoleControlRelation fail:" + e.getMessage());
        }
    }

}
