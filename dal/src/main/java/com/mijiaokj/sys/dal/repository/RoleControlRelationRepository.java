package com.mijiaokj.sys.dal.repository;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.RoleControlRelationMapper;
import com.mijiaokj.sys.domain.RoleControlRelation;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunchenguang on 2017/6/7.
 */
@Repository
public class RoleControlRelationRepository extends BaseRepository<RoleControlRelation> {
    @Resource
    private RoleControlRelationMapper roleControlRelationMapper;
    @Override
    protected BaseMapper<RoleControlRelation> getMapper() {
        return this.roleControlRelationMapper;
    }

    public List<RoleControlRelation> getRoleControlRelationByRoleId(Long roleId){
        return roleControlRelationMapper.getRoleControlRelationByRoleId(roleId);
    }

    public Long createRoleControlRelationByBatch(List<RoleControlRelation> roleControlRelationList) {
        return roleControlRelationMapper.insertByBatch(roleControlRelationList);
    }
}
