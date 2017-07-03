package com.mijiaokj.sys.service.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.MemberUserRepository;
import com.mijiaokj.sys.dal.repository.query.MemberUserCriteria;
import com.mijiaokj.sys.domain.MemberUser;
import com.mijiaokj.sys.service.MemberUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wb-scg178938 on 2017/7/3.
 */
@Service
public class MemberUserServiceImpl implements MemberUserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MemberUserRepository memberUserRepository;

    @Override
    public Result<Long> createMemberUser(MemberUser memberUser) {
        try {
            Preconditions.checkNotNull(memberUser);
            Preconditions.checkNotNull(memberUser.getPhoneNumber(), "PhoneNumber is null");
            Preconditions.checkNotNull(memberUser.getCreator(), "creator is null");
            Preconditions.checkNotNull(memberUser.getModifier(), "modifier is null");
            return Result.ofSuccess(memberUserRepository.insert(memberUser));
        } catch (Exception e) {
            logger.error("createMemberUser " + e);
            return Result.ofFail("create memberUser fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> updateMemberUser(MemberUser memberUser) {
        return null;
    }

    @Override
    public Result<Integer> delete(Long id) {
        return null;
    }

    @Override
    public Result<MemberUser> findByMemberUser(String memberName) {
        return null;
    }

    @Override
    public Result<MemberUser> findById(Long id) {
        return null;
    }

    @Override
    public Result<Page<MemberUser>> queryMemberUserByCriteria(MemberUserCriteria criteria) {
        return null;
    }
}
