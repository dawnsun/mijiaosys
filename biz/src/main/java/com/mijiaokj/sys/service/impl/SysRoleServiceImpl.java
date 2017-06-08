package com.mijiaokj.sys.service.impl;

import java.util.*;

import javax.annotation.Resource;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.mijiaokj.sys.domain.UserRoleRelation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.SysRoleRepository;
import com.mijiaokj.sys.dal.repository.UserRoleRelationRepository;
import com.mijiaokj.sys.domain.SysRole;
import com.mijiaokj.sys.service.SysRoleService;
/**
 * Created by sunchenguang on 2017/6/7.
 * 角色服务实现类
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private SysRoleRepository sysRoleRepository;
	
	@Resource
	private UserRoleRelationRepository userRoleRelationRepository;
	
	@Override
	public Result<List<SysRole>> getRoleByUserId(Long userId) {
		try {
			Preconditions.checkNotNull(userId);
			//通过用户主键查询到用户与角色的关系
			List<UserRoleRelation> userRoleRelationList = userRoleRelationRepository.getUserRoleRelationByUserId(userId);
			Map<String, Object> map = Maps.newHashMap();
			if(null!=userRoleRelationList && !userRoleRelationList.isEmpty()){
				Set<Long> roleIdIdSet = new HashSet<Long>();
				for (UserRoleRelation userRoleRelation : userRoleRelationList){
					roleIdIdSet.add(userRoleRelation.getRoleId());
				}
				map.put("ids",roleIdIdSet.toArray(new Long[roleIdIdSet.size()]));
			}
			//通过用户与角色关系中的角色主键查询用户当前拥有的角色
			List<SysRole> l = sysRoleRepository.getRoleByIds(map);
			return Result.ofSuccess(l);
		} catch (Exception e) {
			logger.error("getRoleByUserId " + e);
			return Result.ofFail("getRoleByUserId fail:" + e.getMessage());
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

	@Override
	public Result<Long> createRole(SysRole sysRole){
		try {
			Preconditions.checkNotNull(sysRole);
			Preconditions.checkNotNull(sysRole.getRoleAbstract(), "RoleAbstract is null");
			Preconditions.checkNotNull(sysRole.getRoleName(), "Password is null");
			Preconditions.checkNotNull(sysRole.getCreator(), "creator is null");
			Preconditions.checkNotNull(sysRole.getModifier(), "modifier is null");
			return Result.ofSuccess(sysRoleRepository.insert(sysRole));
		} catch (Exception e) {
			logger.error("createRole " + e);
			return Result.ofFail("createRole fail:" + e.getMessage());
		}
	}
}
