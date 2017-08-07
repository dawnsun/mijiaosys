package com.mijiaokj.sys.dal.repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.RecommenderIncomeMapper;
import com.mijiaokj.sys.dal.repository.query.RecommenderIncomeCriteria;
import com.mijiaokj.sys.domain.RecommenderIncome;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String,Object> executeQueryForPage(RecommenderIncomeCriteria criteria){
        Map<String,Object> pageMap = new HashMap<>();
        List<RecommenderIncome> datas = recommenderIncomeMapper.selectPageByMap(criteria);
        Integer count = recommenderIncomeMapper.pageCountByMap(criteria);
        pageMap.put("datas",datas);
        pageMap.put("count",count);
        return pageMap;
    }

    /*public Page<RecommenderIncomeDTO> executeQueryForPage(RecommenderIncomeCriteria criteria){
        List<RecommenderIncome> datas = recommenderIncomeMapper.selectPageByMap(criteria);
        Integer count = recommenderIncomeMapper.pageCountByMap(criteria);
        List<RecommenderIncomeDTO> rows = new ArrayList<RecommenderIncomeDTO>();
        if(null!=datas && !datas.isEmpty()){
            for (RecommenderIncome recommenderIncome : datas){
                RecommenderIncomeDTO recommenderIncomeVo = new RecommenderIncomeDTO();
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
    }*/

}
