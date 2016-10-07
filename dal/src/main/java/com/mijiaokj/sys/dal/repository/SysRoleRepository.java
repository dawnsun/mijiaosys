package com.mijiaokj.sys.dal.repository;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.SysRoleMapper;
import com.mijiaokj.sys.domain.SysRole;

@Repository
public class SysRoleRepository extends BaseRepository<SysRole> {
	@Resource
    private SysRoleMapper sysRoleMapper;

	@Override
	protected BaseMapper<SysRole> getMapper() {
		return this.sysRoleMapper;
	}

}
