package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.CropsOperationMapper;
import com.mijiaokj.sys.domain.origin.CropsOperation;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 通过作物id查找作物操作信息
     *
     * @param cropsId
     * @return
     */
    public List<CropsOperation> findListByCropsId(Long cropsId) {
        return cropsOperationMapper.queryCropsOperationByCropsId(cropsId);
    }
}
