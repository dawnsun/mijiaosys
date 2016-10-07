package com.mijiaokj.sys.service;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.SysUser;


/**
 * @author sunchenguang
 * @mail scg16@126.com
 * 用户信息业务服务接口
 */
public interface SysUserService {
	/**
	 * 创建用户信息
	 * @param sysUser
	 * @return
	 */
	 public Result<Long> createSysUser(SysUser sysUser);
	 
	 /**
	  * 通过用户名查找用户
	  * @param userName
	  * @return
	  */
	 public Result<SysUser> findByUsername(String userName);

}
