package com.mijiaokj.sys.dal.repository;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.SysUserMapper;
import com.mijiaokj.sys.domain.SysUser;

@Repository
public class SysUserRepository extends BaseRepository<SysUser> {
	@Resource
    private SysUserMapper sysUserMapper;
	
	public SysUser findByUsername(String username){
		return sysUserMapper.findByUsername(username);
	}

	@Override
	protected BaseMapper<SysUser> getMapper() {
		return this.sysUserMapper;
	}

}
