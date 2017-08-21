package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.LandQualityMapper;
import com.mijiaokj.sys.domain.origin.LandQuality;

import javax.annotation.Resource;

/**
 * Created by wb-scg178938 on 2017/8/7.
 */
public class LandQualityRepository extends BaseRepository<LandQuality> {
    @Resource
    private LandQualityMapper landQualityMapper;
    @Override
    protected BaseMapper<LandQuality> getMapper() {
        return landQualityMapper;
    }
}
