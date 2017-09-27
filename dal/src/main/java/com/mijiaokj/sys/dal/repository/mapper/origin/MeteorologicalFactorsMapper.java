package com.mijiaokj.sys.dal.repository.mapper.origin;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.query.origin.MeteorologicalFactorsCriteria;
import com.mijiaokj.sys.domain.origin.MeteorologicalFactors;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/8/21.
 */
@Mapper
public interface MeteorologicalFactorsMapper extends BaseMapper<MeteorologicalFactors> {
    List<MeteorologicalFactors> queryMeteorologicalFactorsByLandId(Long landId, String date);

    List<MeteorologicalFactors> selectPageByMap(MeteorologicalFactorsCriteria criteria);

    Integer pageCountByMap(MeteorologicalFactorsCriteria criteria);
}
