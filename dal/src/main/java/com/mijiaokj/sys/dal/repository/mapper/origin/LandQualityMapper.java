package com.mijiaokj.sys.dal.repository.mapper.origin;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.query.origin.LandQualityCriteria;
import com.mijiaokj.sys.domain.origin.LandQuality;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/8/7.
 */
@Mapper
public interface LandQualityMapper extends BaseMapper<LandQuality> {

    List<LandQuality> selectPageByMap(LandQualityCriteria criteria);

    Integer pageCountByMap(LandQualityCriteria criteria);
}
