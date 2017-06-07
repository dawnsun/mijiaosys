package com.mijiaokj.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.SysRoleRepository;
import com.mijiaokj.sys.dal.repository.UserRoleRepository;
import com.mijiaokj.sys.domain.SysRole;
import com.mijiaokj.sys.service.SysRoleService;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Resource
	private SysRoleRepository sysRoleRepository;
	
	@Resource
	private UserRoleRepository sysUserRoleRepository;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public Result<List<SysRole>> getRoleByUserId(Long userId) {
		try {
//			Preconditions.checkNotNull(userId);
//			List<SysRole> l = new ArrayList<SysRole>();
//			SysRole role = new SysRole();
//			role.setRoleName("USER");
			List<SysRole> l = sysRoleRepository.getAllRole();
			return Result.ofSuccess(l);
		} catch (Exception e) {
			logger.error("createService " + e);
			return Result.ofFail("create sysUser fail:" + e.getMessage());
		}
	}

	@Override
	public Result<List<SysRole>> getAllRole(){
		try {
			List<SysRole> l = sysRoleRepository.getAllRole();
			return Result.ofSuccess(l);
		} catch (Exception e) {
			logger.error("getAllRole " + e);
			return Result.ofFail("getAllRole fail:" + e.getMessage());
		}
	}
}
