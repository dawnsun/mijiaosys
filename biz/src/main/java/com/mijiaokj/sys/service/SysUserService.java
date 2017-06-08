package com.mijiaokj.sys.service;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.query.SysUserCriteria;
import com.mijiaokj.sys.domain.SysUser;

/**
 * 
 * @ClassName: LoginController
 * @Description: TODO 用户信息操作服务接口
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月13日
 *
 */
public interface SysUserService {
	/**
	 * 创建用户信息
	 * 
	 * @param sysUser
	 * @return
	 */
	public Result<Long> createSysUser(SysUser sysUser);

	/**
	 * update
	 * @param sysUser
	 * @return
	 */
	public Result<Integer> updateSysUser(SysUser sysUser);

	/**
	 * 逻辑删除
	 * @param id
	 * @return
	 */
	public Result<Integer> delete(Long id);

	/**
	 * 通过用户名查找用户
	 * 
	 * @param userName
	 * @return
	 */
	public Result<SysUser> findByUsername(String userName);

	/**
	 * 通过用户id查找用户
	 *
	 * @param id
	 * @return
	 */
	public Result<SysUser> findById(Long id);

	/**
	 * 条件查询，分页查询
	 * 
	 * @param criteria
	 * @return
	 */
	public Result<Page<SysUser>> querySysUserByCriteria(SysUserCriteria criteria);

}
