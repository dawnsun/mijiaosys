package com.mijiaokj.sys.dal.repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.ResControlMapper;
import com.mijiaokj.sys.domain.ResControl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunchenguang on 2017/6/6.
 */
@Repository
public class ResControlRepository extends BaseRepository<ResControl> {
    @Resource
    private ResControlMapper resControlMapper;

    @Override
    protected BaseMapper<ResControl> getMapper() {
        return this.resControlMapper;
    }

    public List<ResControl> getAllResControl(){
        return resControlMapper.getAllResControl();
    }
}
