package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.CropsOperationMapper;
import com.mijiaokj.sys.domain.origin.CropsOperation;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by wb-scg178938 on 2017/8/8.
 */
@Repository
public class CropsOperationRepository extends BaseRepository<CropsOperation> {
    @Resource
    private CropsOperationMapper cropsOperationMapper;
    @Override
    protected BaseMapper<CropsOperation> getMapper() {
        return cropsOperationMapper;
    }
}
