package com.mijiaokj.sys.dal.repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.RoleMenuRelationMapper;
import com.mijiaokj.sys.domain.RoleControlRelation;
import com.mijiaokj.sys.domain.RoleMenuRelation;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 * 角色与菜单之间的关系
 */
@Repository
public class RoleMenuRelationRepository extends BaseRepository<RoleMenuRelation> {
    @Resource
    private RoleMenuRelationMapper roleMenuRelationMapper;

    @Override
    protected BaseMapper<RoleMenuRelation> getMapper() {
        return this.roleMenuRelationMapper;
    }

    public List<RoleMenuRelation> getRoleMenuRelationByRoleId(Long roleId){
        return roleMenuRelationMapper.getRoleMenuRelationByRoleId(roleId);
    }

    public Long createRoleMenuRelationByBatch(List<RoleMenuRelation> roleMenuRelationList) {
        return roleMenuRelationMapper.insertByBatch(roleMenuRelationList);
    }

}
