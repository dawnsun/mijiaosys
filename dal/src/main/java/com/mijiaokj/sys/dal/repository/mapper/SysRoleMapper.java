package com.mijiaokj.sys.dal.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mijiaokj.sys.domain.SysRole;

import java.util.List;
import java.util.Map;

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
	/**
	 * 查询所有的角色
	 * @return
	 */
	List<SysRole> getAllRole();

	/**
	 * 主键IN查询角色
	 * @param map
	 * @return
	 */
	List<SysRole> getRoleByIds(Map<String, Object> map);
}