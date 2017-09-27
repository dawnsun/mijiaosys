package com.mijiaokj.sys.dal.repository.mapper.origin;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.domain.origin.LandRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/8/7.
 */
@Mapper
public interface LandResMapper extends BaseMapper<LandRes> {

    List<LandRes> queryLandResByCreator(String creator);
}
