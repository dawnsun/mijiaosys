package com.mijiaokj.sys.dal.repository.mapper.origin;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.domain.origin.CropsOperation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/8/8.
 */
@Mapper
public interface CropsOperationMapper extends BaseMapper<CropsOperation> {

    /**
     * 通过作物id查找作物操作信息
     *
     * @param cropsId
     * @return
     */
    List<CropsOperation> queryCropsOperationByCropsId(Long cropsId);
}
