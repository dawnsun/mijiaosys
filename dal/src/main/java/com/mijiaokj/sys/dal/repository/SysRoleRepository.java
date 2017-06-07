package com.mijiaokj.sys.dal.repository;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.SysRoleMapper;
import com.mijiaokj.sys.domain.SysRole;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: SysRoleRepository
 * @Description: TODO 系统角色操作
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月13日
 *
 */
@Repository
public class SysRoleRepository extends BaseRepository<SysRole> {
	@Resource
    private SysRoleMapper sysRoleMapper;

	@Override
	protected BaseMapper<SysRole> getMapper() {
		return this.sysRoleMapper;
	}

	public List<SysRole> getAllRole(){
		return sysRoleMapper.getAllRole();
	}

	public List<SysRole> getRoleByIds(Map<String, Object> map){
		return sysRoleMapper.getRoleByIds(map);
	}
}
