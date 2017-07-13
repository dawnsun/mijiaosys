package com.mijiaokj.sys.service;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.query.RecommenderIncomeCriteria;
import com.mijiaokj.sys.domain.RecommenderIncome;
import com.mijiaokj.sys.web.vo.RecommenderIncomeVo;

/**
 * Created by Administrator on 2017/7/13.
 */
public interface RecommenderIncomeService {

    /**
     * 条件查询，分页查询
     *
     * @param criteria
     * @return
     */
    public Result<Page<RecommenderIncomeVo>> queryRecommenderIncomeByCriteria(RecommenderIncomeCriteria criteria);

    /**
     * update
     * @param recommenderIncome
     * @return
     */
    public Result<Integer> updateRecommenderIncome(RecommenderIncome recommenderIncome);

    /**
     * insert
     * @param recommenderIncome
     * @return
     *//*
    public Result<Long> createRecommenderIncome(RecommenderIncome recommenderIncome);*/
}
