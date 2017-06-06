package com.mijiaokj.sys.dal.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mijiaokj.sys.domain.SysRole;

import java.util.List;

/**
 * 
 * @ClassName: SysRoleMapper
 * @Description: TODO 角色信息Mapper
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月14日
 *
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
	List<SysRole> getAllRole();
}