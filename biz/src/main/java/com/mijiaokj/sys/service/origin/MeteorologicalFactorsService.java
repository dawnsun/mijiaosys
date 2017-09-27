package com.mijiaokj.sys.service.origin;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.query.origin.MeteorologicalFactorsCriteria;
import com.mijiaokj.sys.domain.origin.MeteorologicalFactors;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/9/26.
 * 气象要素数据采集记录
 * 初记录每1小时采集一次
 */
public interface MeteorologicalFactorsService {
    /**
     * 创建气象要素信息
     * @param meteorologicalFactors
     * @return
     */
    public Result<Long> createMeteorologicalFactors(MeteorologicalFactors meteorologicalFactors);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    public Result<Integer> delete(Long id);

    /**
     * 修改气象要素信息
     * @param meteorologicalFactors
     * @return
     */
    public Result<Integer> updateMeteorologicalFactors(MeteorologicalFactors meteorologicalFactors);

    /**
     * 通过id查找土地资源信息
     *
     * @param id
     * @return
     */
    public Result<MeteorologicalFactors> findById(Long id);

    /**
     * 通过土地id或日期查询当天数据
     * @param landId
     * @param date
     * @return
     */
    public Result<List<MeteorologicalFactors>> queryMeteorologicalFactorsByLandId(Long landId, String date);

    /**
     * 条件查询，分页查询
     *
     * @param criteria
     * @return
     */
    public Result<Page<MeteorologicalFactors>> queryMeteorologicalFactorsByCriteria(MeteorologicalFactorsCriteria criteria);

}
