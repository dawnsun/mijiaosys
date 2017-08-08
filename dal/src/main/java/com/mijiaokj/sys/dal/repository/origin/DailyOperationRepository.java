package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.domain.origin.DailyOperation;
import org.springframework.stereotype.Repository;

/**
 * Created by wb-scg178938 on 2017/8/8.
 */
@Repository
public class DailyOperationRepository extends BaseRepository<DailyOperation> {
    @Override
    protected BaseMapper<DailyOperation> getMapper() {
        return null;
    }
}
