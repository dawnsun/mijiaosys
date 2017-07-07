package com.mijiaokj.sys.dal.repository.mapper;

import com.mijiaokj.sys.domain.MemberType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberTypeMapper extends BaseMapper<MemberType>{

    List<MemberType> queryMemberTypeAll();
}