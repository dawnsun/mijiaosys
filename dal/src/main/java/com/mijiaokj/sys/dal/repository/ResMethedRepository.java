package com.mijiaokj.sys.dal.repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.ResMethedMapper;
import com.mijiaokj.sys.domain.ResMethed;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunchenguang on 2017/6/6.
 */
@Repository
public class ResMethedRepository extends BaseRepository<ResMethed> {
    @Resource
    private ResMethedMapper resMethedMapper;

    @Override
    protected BaseMapper<ResMethed> getMapper() {
        return this.resMethedMapper;
    }

    public List<ResMethed> getAllResMethed(){
        return resMethedMapper.getAllResMethed();
    }
}
