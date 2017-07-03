package com.mijiaokj.sys.dal.repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.RecommenderIncomeMapper;
import com.mijiaokj.sys.domain.RecommenderIncome;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by wb-scg178938 on 2017/7/3.
 */
@Repository
public class RecommenderIncomeRepository extends BaseRepository<RecommenderIncome>{
    @Resource
    private RecommenderIncomeMapper recommenderIncomeMapper;
    @Override
    protected BaseMapper<RecommenderIncome> getMapper() {
        return recommenderIncomeMapper;
    }
}
