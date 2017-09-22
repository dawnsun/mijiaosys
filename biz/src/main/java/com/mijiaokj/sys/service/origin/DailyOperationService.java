package com.mijiaokj.sys.service.origin;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.query.origin.DailyOperationCriteria;
import com.mijiaokj.sys.domain.origin.DailyOperation;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/9/14.
 * 日常作物操作数据记录服务
 */
public interface DailyOperationService {
    /**
     * 创建日常作物操作数据记录
     * @param dailyOperation
     * @return
     */
    public Result<Long> createDailyOperation(DailyOperation dailyOperation);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    public Result<Integer> delete(Long id);

    /**
     * 修改日常作物操作数据记录
     * @param dailyOperation
     * @return
     */
    public Result<Integer> updateDailyOperation(DailyOperation dailyOperation);

    /**
     * 通过id查找日常作物操作数据记录
     *
     * @param id
     * @return
     */
    public Result<DailyOperation> findById(Long id);

    /**
     * 条件查询，分页查询
     *
     * @param criteria
     * @return
     */
    public Result<Page<DailyOperation>> queryDailyOperationByCriteria(DailyOperationCriteria criteria);
}
