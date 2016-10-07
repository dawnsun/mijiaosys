package com.mijiaokj.sys.dal.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.mijiaokj.sys.domain.SysUser;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
	
	/**
	 * 通过用户名称用户
	 * @param username
	 * @return
	 */
	SysUser findByUsername(String username);
	
}