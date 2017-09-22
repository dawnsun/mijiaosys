package com.mijiaokj.sys.service.origin;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.query.origin.LandQualityCriteria;
import com.mijiaokj.sys.domain.origin.LandQuality;

/**
 * Created by wb-scg178938 on 2017/9/22.
 * 土地质量检测记录操作
 */
public interface LandQualityService {
    /**
     * 创建土地质量检测记录
     * @param landQuality
     * @return
     */
    public Result<Long> createLandQuality(LandQuality landQuality);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    public Result<Integer> delete(Long id);

    /**
     * 修改土地质量检测记录
     * @param landQuality
     * @return
     */
    public Result<Integer> updateLandQuality(LandQuality landQuality);

    /**
     * 通过id查找土地质量检测记录
     *
     * @param id
     * @return
     */
    public Result<LandQuality> findById(Long id);

    /**
     * 条件查询，分页查询
     *
     * @param criteria
     * @return
     */
    public Result<Page<LandQuality>> queryLandQualityByCriteria(LandQualityCriteria criteria);
}
