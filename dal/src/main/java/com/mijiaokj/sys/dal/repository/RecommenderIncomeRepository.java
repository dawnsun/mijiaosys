package com.mijiaokj.sys.dal.repository;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.RecommenderIncomeMapper;
import com.mijiaokj.sys.dal.repository.query.RecommenderIncomeCriteria;
import com.mijiaokj.sys.domain.RecommenderIncome;
import com.mijiaokj.sys.domain.vo.RecommenderIncomeVo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    public Page<RecommenderIncomeVo> executeQueryForPage(RecommenderIncomeCriteria criteria){
        List<RecommenderIncome> datas = recommenderIncomeMapper.selectPageByMap(criteria);
        Integer count = recommenderIncomeMapper.pageCountByMap(criteria);
        List<RecommenderIncomeVo> rows = new ArrayList<RecommenderIncomeVo>();
        if(null!=datas && !datas.isEmpty()){
            for (RecommenderIncome recommenderIncome : datas){
                RecommenderIncomeVo recommenderIncomeVo = new RecommenderIncomeVo();
                recommenderIncomeVo.setEntrant(recommenderIncome.getEntrantId().toString());
                recommenderIncomeVo.setFee(recommenderIncome.getFee());
                recommenderIncomeVo.setGmtWithdrawals(recommenderIncome.getGmtWithdrawals());
                recommenderIncomeVo.setId(recommenderIncome.getId());
                recommenderIncomeVo.setGmtCreate(recommenderIncome.getGmtCreate());
                recommenderIncomeVo.setRecommender(recommenderIncome.getRecommenderId().toString());
                recommenderIncomeVo.setWithdrawals(recommenderIncome.getWithdrawalsType().toString());
                rows.add(recommenderIncomeVo);
            }
        }
        return new Page<>(rows, criteria.getStartRow(), criteria.getPageSize(), count);
    }

}
