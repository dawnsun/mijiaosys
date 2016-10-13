package com.mijiaokj.sys.service;

import com.mijiaokj.sys.common.util.PageData;
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
	 * 通过用户名查找用户
	 * 
	 * @param userName
	 * @return
	 */
	public Result<SysUser> findByUsername(String userName);

	/**
	 * 条件查询，分页查询
	 * 
	 * @param option
	 * @return
	 */
	public Result<PageData<SysUser>> querySysUserByCriteria(SysUserCriteria criteria);

}
