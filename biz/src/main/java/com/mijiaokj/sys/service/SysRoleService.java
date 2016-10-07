package com.mijiaokj.sys.service;

import java.util.List;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.SysRole;

public interface SysRoleService {
	
	/**
	 * 通过用户主键查询用户的所属角色
	 * @param userId
	 * @return
	 */
	public Result<List<SysRole>> getRoleByUserId(Long userId);

}
