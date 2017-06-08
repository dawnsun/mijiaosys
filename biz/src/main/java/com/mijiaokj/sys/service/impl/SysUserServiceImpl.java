package com.mijiaokj.sys.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Page;
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

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private SysUserRepository sysUserRepository;

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
			logger.error("findByUsername " + e);
			return Result.ofFail("findByUsername fail:" + e.getMessage());
		}
	}

	@Override
	public Result<SysUser> findById(Long id){
		try {
			Preconditions.checkNotNull(id, "id is null");
			return Result.ofSuccess(sysUserRepository.getById(id));
		} catch (Exception e) {
			logger.error("findById " + e);
			return Result.ofFail("findById fail:" + e.getMessage());
		}
	}

	@Override
	public Result<Page<SysUser>> querySysUserByCriteria(SysUserCriteria criteria) {
		try {
			Preconditions.checkNotNull(criteria, "criteria is null");
			return Result.ofSuccess(sysUserRepository.executeQueryForPage(criteria));
		} catch (Exception e) {
			logger.error("createService " + e);
			return Result.ofFail("create sysUser fail:" + e.getMessage());
		}
	}

	/**
	 * update
	 * @param sysUser
	 * @return
	 */
	@Override
	public Result<Integer> updateSysUser(SysUser sysUser){
		try {
			Preconditions.checkNotNull(sysUser, "sysUser is null");
			return Result.ofSuccess(sysUserRepository.update(sysUser));
		} catch (Exception e) {
			logger.error("createService " + e);
			return Result.ofFail("create sysUser fail:" + e.getMessage());
		}
	}

	/**
	 * 逻辑删除
	 * @param id
	 * @return
	 */
	@Override
	public Result<Integer> delete(Long id){
		try {
			Preconditions.checkNotNull(id, "id is null");
			return Result.ofSuccess(sysUserRepository.delete(id));
		} catch (Exception e) {
			logger.error("createService " + e);
			return Result.ofFail("create sysUser fail:" + e.getMessage());
		}
	}
}
