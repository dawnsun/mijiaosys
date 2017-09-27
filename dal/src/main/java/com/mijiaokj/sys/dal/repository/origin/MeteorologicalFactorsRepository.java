package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.MeteorologicalFactorsMapper;
import com.mijiaokj.sys.dal.repository.query.origin.MeteorologicalFactorsCriteria;
import com.mijiaokj.sys.domain.origin.LandQuality;
import com.mijiaokj.sys.domain.origin.MeteorologicalFactors;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/8/21.
 * 气象要素记录
 */
@Repository
public class MeteorologicalFactorsRepository extends BaseRepository<MeteorologicalFactors> {
    @Resource
    private MeteorologicalFactorsMapper meteorologicalFactorsMapper;
    @Override
    protected BaseMapper getMapper() {
        return meteorologicalFactorsMapper;
    }

    public List<MeteorologicalFactors>queryMeteorologicalFactorsByLandId(Long landId, String date) {
        return meteorologicalFactorsMapper.queryMeteorologicalFactorsByLandId(landId,date);
    }

    public Page<MeteorologicalFactors> executeQueryForPage(MeteorologicalFactorsCriteria criteria) {
        List<MeteorologicalFactors> datas = meteorologicalFactorsMapper.selectPageByMap(criteria);
        Integer count = meteorologicalFactorsMapper.pageCountByMap(criteria);
        return new Page<>(datas, criteria.getStartRow(), criteria.getPageSize(), count);
    }
}
