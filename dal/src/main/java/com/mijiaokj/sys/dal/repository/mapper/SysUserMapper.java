package com.mijiaokj.sys.dal.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.mijiaokj.sys.dal.repository.query.SysUserCriteria;
import com.mijiaokj.sys.domain.SysUser;
/**
 * 
 * @ClassName: SysUserMapper
 * @Description: TODO 用户信息Mapper
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月14日
 *
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
	
	/**
	 * 通过用户名称用户
	 * @param username
	 * @return
	 */
	SysUser findByUsername(String username);
	
	/**
	 * 条件查询用户列表
	 * @param criteria
	 * @return
	 */
	List<SysUser> selectPageByMap(SysUserCriteria criteria);

	/**
	 * 条件查询分页所用数据
	 * @param criteria
	 * @return
	 */
	int pageCountByMap(SysUserCriteria criteria);
	
}