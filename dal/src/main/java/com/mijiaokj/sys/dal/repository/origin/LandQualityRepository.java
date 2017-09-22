package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.LandQualityMapper;
import com.mijiaokj.sys.dal.repository.query.origin.LandQualityCriteria;
import com.mijiaokj.sys.domain.origin.LandQuality;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/8/7.
 */
@Repository
public class LandQualityRepository extends BaseRepository<LandQuality> {

    @Resource
    private LandQualityMapper landQualityMapper;

    @Override
    protected BaseMapper<LandQuality> getMapper() {
        return landQualityMapper;
    }

    public Page<LandQuality> executeQueryForPage(LandQualityCriteria criteria){
        List<LandQuality> datas = landQualityMapper.selectPageByMap(criteria);
        Integer count = landQualityMapper.pageCountByMap(criteria);
        return new Page<>(datas, criteria.getStartRow(), criteria.getPageSize(), count);
    }
}
