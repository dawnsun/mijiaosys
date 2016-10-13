package com.mijiaokj.sys.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.PageData;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.SysUserRepository;
import com.mijiaokj.sys.dal.repository.query.SysUserCriteria;
import com.mijiaokj.sys.domain.SysUser;
import com.mijiaokj.sys.service.SysUserService;

/**
 * 
 * @ClassName: LoginController
 * @Description: TODO 用户信息操作服务实现
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月13日
 *
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Resource
	private SysUserRepository sysUserRepository;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Result<Long> createSysUser(SysUser sysUser) {
		try {
			Preconditions.checkNotNull(sysUser);
			Preconditions.checkNotNull(sysUser.getPhoneNumber(), "PhoneNumber is null");
			Preconditions.checkNotNull(sysUser.getPassword(), "Password is null");
			Preconditions.checkNotNull(sysUser.getCreator(), "creator is null");
			Preconditions.checkNotNull(sysUser.getModifier(), "modifier is null");
			return Result.ofSuccess(sysUserRepository.insert(sysUser));
		} catch (Exception e) {
			logger.error("createSysUser " + e);
			return Result.ofFail("create sysUser fail:" + e.getMessage());
		}
	}
	
	@Override
	public Result<SysUser> findByUsername(String username) {
		try {
			Preconditions.checkNotNull(username, "userName is null");
			return Result.ofSuccess(sysUserRepository.findByUsername(username));
		} catch (Exception e) {
			logger.error("createSysUser " + e);
			return Result.ofFail("create sysUser fail:" + e.getMessage());
		}
	}

	@Override
	public Result<PageData<SysUser>> querySysUserByCriteria(SysUserCriteria criteria) {
		try {
			Preconditions.checkNotNull(criteria, "criteria is null");
			return Result.ofSuccess(sysUserRepository.executeQueryForPage(criteria));
		} catch (Exception e) {
			logger.error("createService " + e);
			return Result.ofFail("create sysUser fail:" + e.getMessage());
		}
	}

}
