package com.mijiaokj.sys.dal.repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.MemberTypeMapper;
import com.mijiaokj.sys.domain.MemberType;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/7/3.
 */
@Repository
public class MemberTypeRepository extends BaseRepository<MemberType>{
    @Resource
    private MemberTypeMapper memberTypeMapper;
    @Override
    protected BaseMapper<MemberType> getMapper() {
        return memberTypeMapper;
    }

    public List<MemberType> queryMemberTypeAll() {
        return memberTypeMapper.queryMemberTypeAll();
    }
}
