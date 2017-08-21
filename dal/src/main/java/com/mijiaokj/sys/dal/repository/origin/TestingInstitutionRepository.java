package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.TestingInstitutionMapper;
import com.mijiaokj.sys.domain.origin.TestingInstitution;

import javax.annotation.Resource;

/**
 * Created by wb-scg178938 on 2017/8/7.
 */
public class TestingInstitutionRepository extends BaseRepository<TestingInstitution> {
    @Resource
    private TestingInstitutionMapper testingInstitutionMapper;
    @Override
    protected BaseMapper<TestingInstitution> getMapper() {
        return testingInstitutionMapper;
    }
}
