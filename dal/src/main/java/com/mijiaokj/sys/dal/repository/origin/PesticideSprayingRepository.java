package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.PesticideSprayingMapper;
import com.mijiaokj.sys.domain.origin.PesticideSpraying;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by wb-scg178938 on 2017/8/21.
 */
@Repository
public class PesticideSprayingRepository extends BaseRepository<PesticideSpraying> {
    @Resource
    private PesticideSprayingMapper pesticideSprayingMapper;
    @Override
    protected BaseMapper<PesticideSpraying> getMapper() {
        return pesticideSprayingMapper;
    }
}
