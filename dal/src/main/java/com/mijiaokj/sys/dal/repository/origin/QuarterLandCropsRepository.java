package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.QuarterLandCropsMapper;
import com.mijiaokj.sys.domain.origin.QuarterLandCrops;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/7.
 */
@Repository
public class QuarterLandCropsRepository extends BaseRepository<QuarterLandCrops> {
    @Resource
    private QuarterLandCropsMapper quarterLandCropsMapper;
    @Override
    protected BaseMapper<QuarterLandCrops> getMapper() {
        return quarterLandCropsMapper;
    }
}
