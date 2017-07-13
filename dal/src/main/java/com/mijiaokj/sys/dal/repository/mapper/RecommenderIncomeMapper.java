package com.mijiaokj.sys.dal.repository.mapper;

import com.mijiaokj.sys.dal.repository.query.MemberUserCriteria;
import com.mijiaokj.sys.dal.repository.query.RecommenderIncomeCriteria;
import com.mijiaokj.sys.domain.RecommenderIncome;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecommenderIncomeMapper extends BaseMapper<RecommenderIncome>{

    List<RecommenderIncome> selectPageByMap(RecommenderIncomeCriteria criteria);

    Integer pageCountByMap(RecommenderIncomeCriteria criteria);

}