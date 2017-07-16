package com.mijiaokj.sys.service.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.common.util.WithdrawalsEnum;
import com.mijiaokj.sys.dal.repository.MemberUserRepository;
import com.mijiaokj.sys.dal.repository.RecommenderIncomeRepository;
import com.mijiaokj.sys.dal.repository.query.RecommenderIncomeCriteria;
import com.mijiaokj.sys.domain.MemberUser;
import com.mijiaokj.sys.domain.RecommenderIncome;
import com.mijiaokj.sys.domain.vo.RecommenderIncomeVo;
import com.mijiaokj.sys.service.RecommenderIncomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/13.
 */
@Service("recommenderIncomeService")
public class RecommenderIncomeServiceImpl implements RecommenderIncomeService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private RecommenderIncomeRepository recommenderIncomeRepository;
    @Resource
    private MemberUserRepository memberUserRepository;
    @Override
    public Result<Page<RecommenderIncomeVo>> queryRecommenderIncomeByCriteria(RecommenderIncomeCriteria criteria) {
        try {
            Preconditions.checkNotNull(criteria, "criteria is null");
            Map<String,Object> pageMap = recommenderIncomeRepository.executeQueryForPage(criteria);
            return Result.ofSuccess(assembleForPage(pageMap,criteria));
        } catch (Exception e) {
            logger.error("RecommenderIncomeService queryRecommenderIncomeByCriteria " + e);
            return Result.ofFail("query page recommenderIncome fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> updateRecommenderIncome(RecommenderIncome recommenderIncome) {
        try {
            Preconditions.checkNotNull(recommenderIncome, "recommenderIncome is null");
            return Result.ofSuccess(recommenderIncomeRepository.update(recommenderIncome));
        } catch (Exception e) {
            logger.error("RecommenderIncomeService updateRecommenderIncome " + e);
            return Result.ofFail("update updateRecommenderIncome fail:" + e.getMessage());
        }
    }

    /*@Override
    public Result<Long> createRecommenderIncome(RecommenderIncome recommenderIncome) {
        try {
            Preconditions.checkNotNull(recommenderIncome);
            Preconditions.checkNotNull(recommenderIncome.getCreator(), "creator is null");
            Preconditions.checkNotNull(recommenderIncome.getModifier(), "modifier is null");
            return Result.ofSuccess(recommenderIncomeRepository.insert(recommenderIncome));
        } catch (Exception e) {
            logger.error("RecommenderIncomeService createRecommenderIncome " + e);
            return Result.ofFail("create recommenderIncome fail:" + e.getMessage());
        }
    }*/

    public Page<RecommenderIncomeVo> assembleForPage(Map<String,Object> pageMap,RecommenderIncomeCriteria criteria){
        Integer count = 0;
        List<RecommenderIncomeVo> rows = new ArrayList<RecommenderIncomeVo>();
        if(null!=pageMap && !pageMap.isEmpty()){
            Object countObj = pageMap.get("count");
            count = Integer.parseInt(countObj.toString());
            Object datasObj = pageMap.get("datas");
            List<RecommenderIncome> recommenderIncomeList = (List<RecommenderIncome>)datasObj;
            for (RecommenderIncome recommenderIncome : recommenderIncomeList){
                RecommenderIncomeVo recommenderIncomeVo = new RecommenderIncomeVo();
                recommenderIncomeVo.setEntrant(getMemberName(recommenderIncome.getEntrantId()));
                recommenderIncomeVo.setFee(recommenderIncome.getFee());
                recommenderIncomeVo.setGmtWithdrawals(recommenderIncome.getGmtWithdrawals());
                recommenderIncomeVo.setId(recommenderIncome.getId());
                recommenderIncomeVo.setGmtCreate(recommenderIncome.getGmtCreate());
                recommenderIncomeVo.setRecommender(getMemberName(recommenderIncome.getRecommenderId()));
                recommenderIncomeVo.setWithdrawals( WithdrawalsEnum.getWithdrawals(recommenderIncome.getWithdrawalsType()));
                rows.add(recommenderIncomeVo);
            }
        }
        return new Page<>(rows, criteria.getStartRow(), criteria.getPageSize(), count);
    }

    public String getMemberName(Long id){
        MemberUser memberUser = memberUserRepository.getById(id);
        return memberUser.getMemberName();
    }
}
