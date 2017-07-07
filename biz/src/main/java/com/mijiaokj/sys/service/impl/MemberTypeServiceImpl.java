package com.mijiaokj.sys.service.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.MemberTypeRepository;
import com.mijiaokj.sys.domain.MemberType;
import com.mijiaokj.sys.service.MemberTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/7/8.
 */
@Service
public class MemberTypeServiceImpl implements MemberTypeService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MemberTypeRepository memberTypeRepository;
    @Override
    public Result<Long> createMemberType(MemberType memberType) {
        return null;
    }

    @Override
    public Result<Integer> updateMemberType(MemberType memberType) {
        return null;
    }

    @Override
    public Result<Integer> delete(Long id) {
        return null;
    }

    @Override
    public Result<MemberType> findById(Long id) {
        return null;
    }

    @Override
    public Result<List<MemberType>> queryMemberTypeAll() {
        try {
            return Result.ofSuccess(memberTypeRepository.queryMemberTypeAll());
        } catch (Exception e) {
            logger.error("MemberUserService findById " + e);
            return Result.ofFail("findById fail:" + e.getMessage());
        }
    }
}
