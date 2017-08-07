package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.domain.origin.PhenologicalPhase;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/8/7.
 */
@Repository
public class PhenologicalPhaseRepository extends BaseRepository<PhenologicalPhase> {
    @Override
    protected BaseMapper<PhenologicalPhase> getMapper() {
        return null;
    }
}
