package com.mijiaokj.sys.dal.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mijiaokj.sys.domain.UserRoleRelation;

import java.util.List;

/**
 * 
 * @ClassName: UserRoleRelationMapper
 * @Description: TODO 用户角色关系表Mapper
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月14日
 *
 */
@Mapper
public interface UserRoleRelationMapper extends BaseMapper<UserRoleRelation> {
    List<UserRoleRelation> getUserRoleRelationByUserId(Long userId);
}