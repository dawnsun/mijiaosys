package com.mijiaokj.sys.dal.repository;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.SysUserRoleRelationMapper;
import com.mijiaokj.sys.domain.SysUserRoleRelation;
/**
 * 
 * @ClassName: SysUserRoleRepository
 * @Description: TODO 用户角色关系操作
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月13日
 *
 */
@Repository
public class SysUserRoleRepository extends BaseRepository<SysUserRoleRelation> {

	@Resource
    private SysUserRoleRelationMapper sysUserRoleMapper;
	
	@Override
	protected BaseMapper<SysUserRoleRelation> getMapper() {
		return this.sysUserRoleMapper;
	}

}
