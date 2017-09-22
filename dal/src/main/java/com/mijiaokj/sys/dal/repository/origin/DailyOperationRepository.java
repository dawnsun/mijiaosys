package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.DailyOperationMapper;
import com.mijiaokj.sys.dal.repository.query.MemberUserCriteria;
import com.mijiaokj.sys.dal.repository.query.origin.DailyOperationCriteria;
import com.mijiaokj.sys.domain.MemberUser;
import com.mijiaokj.sys.domain.origin.DailyOperation;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/8/8.
 */
@Repository
public class DailyOperationRepository extends BaseRepository<DailyOperation> {
    @Resource
    private DailyOperationMapper dailyOperationMapper;
    @Override
    protected BaseMapper<DailyOperation> getMapper() {
        return dailyOperationMapper;
    }

    public Page<DailyOperation> executeQueryForPage(DailyOperationCriteria criteria){
        List<DailyOperation> datas = dailyOperationMapper.selectPageByMap(criteria);
        Integer count = dailyOperationMapper.pageCountByMap(criteria);
        return new Page<>(datas, criteria.getStartRow(), criteria.getPageSize(), count);
    }
}
