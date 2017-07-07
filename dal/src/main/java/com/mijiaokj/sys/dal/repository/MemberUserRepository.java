package com.mijiaokj.sys.dal.repository;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.MemberUserMapper;
import com.mijiaokj.sys.dal.repository.query.MemberUserCriteria;
import com.mijiaokj.sys.dal.repository.query.SysUserCriteria;
import com.mijiaokj.sys.domain.MemberUser;
import com.mijiaokj.sys.domain.SysUser;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/7/3.
 */
@Repository
public class MemberUserRepository extends BaseRepository<MemberUser> {

    @Resource
    private MemberUserMapper memberUserMapper;
    @Override
    protected BaseMapper<MemberUser> getMapper() {
        return memberUserMapper;
    }

    public Page<MemberUser> executeQueryForPage(MemberUserCriteria criteria){
        List<MemberUser> datas = memberUserMapper.selectPageByMap(criteria);
        Integer count = memberUserMapper.pageCountByMap(criteria);
        return new Page<>(datas, criteria.getStartRow(), criteria.getPageSize(), count);
    }

    public MemberUser findByMemberUser(String memberName){
        return memberUserMapper.findByMemberUser(memberName);
    }

    public MemberUser findByPhoneNumber(String phoneNumber){
        return memberUserMapper.findByPhoneNumber(phoneNumber);
    }

    public List<MemberUser> getAvailableRecommender() {
        return memberUserMapper.getAvailableRecommender();
    }
}
