package com.mijiaokj.sys.dal.repository.mapper.origin;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.domain.origin.Crops;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/8/7.
 */
@Mapper
public interface CropsMapper extends BaseMapper<Crops> {

    /**
     * 通过父节点查询所有的子节点作物信息
     * @param parentId
     * @return
     */
    List<Crops> queryCropsByParentId(Long parentId);

    /**
     * 通过作物名称模糊查找作物配置信息
     * @param cropsName
     * @return
     */
    List<Crops> queryCropsByCropsName(String cropsName);
}
