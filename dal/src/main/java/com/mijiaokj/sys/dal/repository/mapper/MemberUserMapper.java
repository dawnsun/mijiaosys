package com.mijiaokj.sys.dal.repository.mapper;

import com.mijiaokj.sys.dal.repository.query.MemberUserCriteria;
import com.mijiaokj.sys.domain.MemberUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberUserMapper extends BaseMapper<MemberUser>{

    /**
     * 查询会员分页列表
     * @param criteria
     * @return
     */
    List<MemberUser> selectPageByMap(MemberUserCriteria criteria);

    /**
     * 查询会员分页列表页数
     * @param criteria
     * @return
     */
    Integer pageCountByMap(MemberUserCriteria criteria);
}