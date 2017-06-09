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
    /**
     * 通过用户主键查询用户所具有的角色
     * @param userId
     * @return
     */
    List<UserRoleRelation> getUserRoleRelationByUserId(Long userId);

    /**
     * 批量插入关联关系
     * @param userRoleRelationList
     * @return
     */
    Long insertByBatch(List<UserRoleRelation> userRoleRelationList);
}