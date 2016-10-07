package com.mijiaokj.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.SysRoleRepository;
import com.mijiaokj.sys.dal.repository.SysUserRoleRepository;
import com.mijiaokj.sys.domain.SysRole;
import com.mijiaokj.sys.domain.SysUser;
import com.mijiaokj.sys.service.SysRoleService;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Resource
	private SysRoleRepository sysRoleRepository;
	
	@Resource
	private SysUserRoleRepository sysUserRoleRepository;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public Result<List<SysRole>> getRoleByUserId(Long userId) {
			try {
				Preconditions.checkNotNull(userId);
				List<SysRole> l = new ArrayList<SysRole>();
				SysRole role = new SysRole();
				role.setRoleName("USER");
				l.add(role);
				return Result.ofSuccess(l);
	} catch (Exception e) {
		logger.error("createService " + e);
		return Result.ofFail("create sysUser fail:" + e.getMessage());
	}
	}
	
}
