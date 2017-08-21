package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.PesticidesCategoryMapper;
import com.mijiaokj.sys.domain.origin.PesticidesCategory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by wb-scg178938 on 2017/8/21.
 */
@Repository
public class PesticidesCategoryRepository extends BaseRepository<PesticidesCategory> {
    @Resource
    private PesticidesCategoryMapper pesticidesCategoryMapper;
    @Override
    protected BaseMapper<PesticidesCategory> getMapper() {
        return pesticidesCategoryMapper;
    }
}
