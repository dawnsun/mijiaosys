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
import java.util.List;

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
            logger.error("MemberUserService createMemberUser " + e);
            return Result.ofFail("create memberUser fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> updateMemberUser(MemberUser memberUser) {
        try {
            Preconditions.checkNotNull(memberUser, "memberUser is null");
            return Result.ofSuccess(memberUserRepository.update(memberUser));
        } catch (Exception e) {
            logger.error("MemberUserService updateMemberUser " + e);
            return Result.ofFail("update memberUser fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> delete(Long id) {
        try {
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(memberUserRepository.delete(id));
        } catch (Exception e) {
            logger.error("MemberUserService delete " + e);
            return Result.ofFail("delete memberUser fail:" + e.getMessage());
        }
    }

    @Override
    public Result<MemberUser> findByMemberUser(String memberName) {
        try {
            Preconditions.checkNotNull(memberName, "memberName is null");
            return Result.ofSuccess(memberUserRepository.findByMemberUser(memberName));
        } catch (Exception e) {
            logger.error("MemberUserService findByMemberUser " + e);
            return Result.ofFail("findByUsername fail:" + e.getMessage());
        }
    }

    @Override
    public Result<MemberUser> findByPhoneNumber(String phoneNumber) {
        try {
            Preconditions.checkNotNull(phoneNumber, "phoneNumber is null");
            return Result.ofSuccess(memberUserRepository.findByPhoneNumber(phoneNumber));
        } catch (Exception e) {
            logger.error("MemberUserService findByMemberUser " + e);
            return Result.ofFail("findByUsername fail:" + e.getMessage());
        }
    }

    @Override
    public Result<List<MemberUser>> getAvailableRecommender() {
        try {
            return Result.ofSuccess(memberUserRepository.getAvailableRecommender());
        } catch (Exception e) {
            logger.error("MemberUserService findByMemberUser " + e);
            return Result.ofFail("findByUsername fail:" + e.getMessage());
        }
    }

    @Override
    public Result<MemberUser> findById(Long id) {
        try {
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(memberUserRepository.getById(id));
        } catch (Exception e) {
            logger.error("MemberUserService findById " + e);
            return Result.ofFail("findById fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Page<MemberUser>> queryMemberUserByCriteria(MemberUserCriteria criteria) {
        try {
            Preconditions.checkNotNull(criteria, "criteria is null");
            return Result.ofSuccess(memberUserRepository.executeQueryForPage(criteria));
        } catch (Exception e) {
            logger.error("createService queryMemberUserByCriteria " + e);
            return Result.ofFail("create sysUser fail:" + e.getMessage());
        }
    }

}
