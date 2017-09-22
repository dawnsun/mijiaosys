package com.mijiaokj.sys.dal.repository.mapper.origin;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.query.origin.DailyOperationCriteria;
import com.mijiaokj.sys.domain.MemberUser;
import com.mijiaokj.sys.domain.origin.DailyOperation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/8/8.
 */
@Mapper
public interface DailyOperationMapper extends BaseMapper<DailyOperation> {

    List<DailyOperation> selectPageByMap(DailyOperationCriteria criteria);

    Integer pageCountByMap(DailyOperationCriteria criteria);
}
