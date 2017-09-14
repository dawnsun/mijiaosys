package com.mijiaokj.sys.service.origin;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.origin.Crops;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/9/14.
 * 作物基础信息维护服务
 */
public interface CropsService {
    /**
     * 创建农作物信息
     * @param crops
     * @return
     */
    public Result<Long> createCrops(Crops crops);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    public Result<Integer> delete(Long id);

    /**
     * 修改作物信息
     * @param crops
     * @return
     */
    public Result<Integer> updateCrops(Crops crops);

    /**
     * 通过id查找作物信息
     *
     * @param id
     * @return
     */
    public Result<Crops> findById(Long id);

    /**
     * 通过父作物id查找作物信息
     *
     * @param parentId
     * @return
     */
    public Result<List<Crops>> findListByParentId(Long parentId);

    /**
     * 通过作物名称模糊查找坐下基础数据
     * @param cropsName
     * @return
     */
    public Result<List<Crops>> findListByCropsName(String cropsName);

}
