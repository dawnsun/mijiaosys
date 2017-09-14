package com.mijiaokj.sys.service.origin;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.origin.CropsOperation;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/9/14.
 * CropsOperation 作物操作基本数据信息配置
 */
public interface CropsOperationService {
    /**
     * 创建作物操作基本数据
     * @param cropsOperation
     * @return
     */
    public Result<Long> createCropsOperation(CropsOperation cropsOperation);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    public Result<Integer> delete(Long id);

    /**
     * 修改作物操作基本数据
     * @param cropsOperation
     * @return
     */
    public Result<Integer> updateCropsOperation(CropsOperation cropsOperation);

    /**
     * 通过id查找作物操作基本数据
     *
     * @param id
     * @return
     */
    public Result<CropsOperation> findById(Long id);

    /**
     * 通过作物id查找作物操作信息
     *
     * @param cropsId
     * @return
     */
    public Result<List<CropsOperation>> findListByCropsId(Long cropsId);
}
