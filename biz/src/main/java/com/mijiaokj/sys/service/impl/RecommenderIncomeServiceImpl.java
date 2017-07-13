package com.mijiaokj.sys.service.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.RecommenderIncomeRepository;
import com.mijiaokj.sys.dal.repository.mapper.RecommenderIncomeMapper;
import com.mijiaokj.sys.dal.repository.query.RecommenderIncomeCriteria;
import com.mijiaokj.sys.domain.RecommenderIncome;
import com.mijiaokj.sys.service.RecommenderIncomeService;
import com.mijiaokj.sys.web.vo.RecommenderIncomeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/13.
 */
@Service("recommenderIncomeService")
public class RecommenderIncomeServiceImpl implements RecommenderIncomeService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private RecommenderIncomeRepository recommenderIncomeRepository;
    @Override
    public Result<Page<RecommenderIncomeVo>> queryRecommenderIncomeByCriteria(RecommenderIncomeCriteria criteria) {
        try {
            Preconditions.checkNotNull(criteria, "criteria is null");
            return Result.ofSuccess(recommenderIncomeRepository.executeQueryForPage(criteria));
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
}
