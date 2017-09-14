package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.origin.CropsMapper;
import com.mijiaokj.sys.domain.origin.Crops;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/8/7.
 */
@Repository
public class CropsRepository extends BaseRepository<Crops> {
    @Resource
    private CropsMapper cropsMapper;
    @Override
    protected BaseMapper getMapper() {
        return cropsMapper;
    }

    /**
     * 通过父节点查询所有的子节点作物信息
     * @param parentId
     * @return
     */
    public List<Crops> findListByParentId(Long parentId) {
        return cropsMapper.queryCropsByParentId(parentId);
    }

    public List<Crops> findListByCropsName(String cropsName){
        return cropsMapper.queryCropsByCropsName(cropsName);
    }
}
