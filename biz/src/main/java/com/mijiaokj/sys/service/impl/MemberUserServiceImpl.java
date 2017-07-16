package com.mijiaokj.sys.service.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Money;
import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.common.util.WithdrawalsEnum;
import com.mijiaokj.sys.dal.repository.MemberTypeRepository;
import com.mijiaokj.sys.dal.repository.MemberUserRepository;
import com.mijiaokj.sys.dal.repository.RecommenderIncomeRepository;
import com.mijiaokj.sys.dal.repository.query.MemberUserCriteria;
import com.mijiaokj.sys.domain.MemberType;
import com.mijiaokj.sys.domain.MemberUser;
import com.mijiaokj.sys.domain.RecommenderIncome;
import com.mijiaokj.sys.service.MemberUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Resource
    private RecommenderIncomeRepository recommenderIncomeRepository;
    @Resource
    private MemberTypeRepository memberTypeRepository;

    @Override
    @Transactional
    public Result<Long> createMemberUser(MemberUser memberUser) {
        try {
            Preconditions.checkNotNull(memberUser);
            Preconditions.checkNotNull(memberUser.getPhoneNumber(), "PhoneNumber is null");
            Preconditions.checkNotNull(memberUser.getCreator(), "creator is null");
            Preconditions.checkNotNull(memberUser.getModifier(), "modifier is null");
            Long id = memberUserRepository.insert(memberUser);
            if(!memberUser.getRecommenderId().equals(0L)){
                RecommenderIncome recommenderIncome = new RecommenderIncome();
                recommenderIncome.setEntrantId(id);
                recommenderIncome.setFee(getFee(memberUser.getMemberTypeId()));
                recommenderIncome.setRecommenderId(memberUser.getRecommenderId());
                recommenderIncome.setWithdrawalsType(WithdrawalsEnum.cashWithdrawal.getKey());
                recommenderIncome.setCreator(memberUser.getCreator());
                recommenderIncome.setModifier(memberUser.getModifier());
                recommenderIncomeRepository.insert(recommenderIncome);
            }

            return Result.ofSuccess(id);
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

    public String getFee(Long id){
        MemberType memberType = memberTypeRepository.getById(id);
        double rate = Double.valueOf(memberType.getRate());
        Money fee = new Money(memberType.getFee());
        return fee.multiplyBy(rate).getAmount().toString();
    }

}
