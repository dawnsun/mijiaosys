package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.MeteorologicalFactorsMapper;
import com.mijiaokj.sys.domain.origin.MeteorologicalFactors;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

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
}
