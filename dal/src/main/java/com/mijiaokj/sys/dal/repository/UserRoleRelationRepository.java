package com.mijiaokj.sys.dal.repository;

import javax.annotation.Resource;

import com.mijiaokj.sys.dal.repository.mapper.UserRoleRelationMapper;
import com.mijiaokj.sys.domain.UserRoleRelation;
import org.springframework.stereotype.Repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;

import java.util.List;

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
public class UserRoleRelationRepository extends BaseRepository<UserRoleRelation> {

	@Resource
    private UserRoleRelationMapper userRoleRelationMapper;
	
	@Override
	protected BaseMapper<UserRoleRelation> getMapper() {
		return this.userRoleRelationMapper;
	}

	public List<UserRoleRelation> getUserRoleRelationByUserId(Long userId){
		return userRoleRelationMapper.getUserRoleRelationByUserId(userId);
	}
}
