package com.mijiaokj.sys.dal.repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.SysFileMapper;
import com.mijiaokj.sys.domain.SysFile;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/13.
 */
@Repository
public class SysFileRepository extends BaseRepository<SysFile> {
    @Resource
    SysFileMapper sysFileMapper;
    @Override
    protected BaseMapper<SysFile> getMapper() {
        return this.sysFileMapper;
    }
}
