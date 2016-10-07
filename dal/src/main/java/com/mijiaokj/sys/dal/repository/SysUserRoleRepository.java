package com.mijiaokj.sys.dal.repository;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.SysUserRoleMapper;
import com.mijiaokj.sys.domain.SysUserRole;

@Repository
public class SysUserRoleRepository extends BaseRepository<SysUserRole> {

	@Resource
    private SysUserRoleMapper sysUserRoleMapper;
	
	@Override
	protected BaseMapper<SysUserRole> getMapper() {
		return this.sysUserRoleMapper;
	}

}
