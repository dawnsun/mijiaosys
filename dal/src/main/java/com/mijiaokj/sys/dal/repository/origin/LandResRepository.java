package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.LandResMapper;
import com.mijiaokj.sys.domain.origin.LandRes;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/8/7.
 * 土地资源Repository
 * 农户维护自己的土地信息
 */
@Repository
public class LandResRepository extends BaseRepository<LandRes> {
    @Resource
    private LandResMapper landResMapper;
    @Override
    protected BaseMapper getMapper() {
        return landResMapper;
    }

    public List<LandRes> queryLandResByCreator(String creator) {
        return landResMapper.queryLandResByCreator(creator);
    }
}
