package com.mijiaokj.sys.dal.repository;

import javax.annotation.Resource;

import com.mijiaokj.sys.dal.repository.mapper.UserRoleRelationMapper;
import com.mijiaokj.sys.domain.UserRoleRelation;
import org.springframework.stereotype.Repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;

/**
 * 
 * @ClassName: SysUserRoleRepository
 * @Description: TODO 用户角色关系操作
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月13日
 *
 */
@Repository
public class UserRoleRepository extends BaseRepository<UserRoleRelation> {

	@Resource
    private UserRoleRelationMapper sysUserRoleMapper;
	
	@Override
	protected BaseMapper<UserRoleRelation> getMapper() {
		return this.sysUserRoleMapper;
	}

}
