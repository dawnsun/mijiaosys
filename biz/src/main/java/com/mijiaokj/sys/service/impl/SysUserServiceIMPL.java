package com.mijiaokj.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.SysUserRepository;
import com.mijiaokj.sys.domain.SysUser;
import com.mijiaokj.sys.service.SysUserService;

@Service
public class SysUserServiceIMPL implements SysUserService{
	
	@Resource
	private SysUserRepository sysUserRepository;

	@Override
	public Result<Long> createSysUser(SysUser sysUser) {
		// TODO Auto-generated method stub
		sysUserRepository.insert(sysUser);
		return null;
	}

}
