package com.mijiaokj.sys.service;

import java.util.List;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.SysRole;

/**
 * Created by sunchenguang on 2017/6/7.
 * 角色服务接口
 */
public interface SysRoleService {
	
	/**
	 * 通过用户主键查询用户的所属角色
	 * @param userId
	 * @return
	 */
	public Result<List<SysRole>> getRoleByUserId(Long userId);

	/**
	 * 查询所有有效的定义角色
	 * @return
	 */
	public Result<List<SysRole>> getAllRole();

    /**
     * 创建角色
     * @param sysRole
     * @return
     */
	public Result<Long> createRole(SysRole sysRole);

    /**
     * 修改角色
     * @param sysRole
     * @return
     */
	public Result<Integer> updateRole(SysRole sysRole);

    /**
     * 删除角色
     * @param id
     * @return
     */
	public Result<Integer> deleteRole(Long id);

    /**
     * 通过主键查询
     * @param id
     * @return
     */
	public Result<SysRole> findSysRoleById(Long id);
}
