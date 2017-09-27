package com.mijiaokj.sys.service.origin;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.query.origin.PesticidesCategoryCriteria;
import com.mijiaokj.sys.domain.origin.PesticidesCategory;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/9/27.
 * 农药类目信息维护
 */
public interface PesticidesCategoryService {
    /**
     * 创建农药类目信息
     * @param pesticidesCategory
     * @return
     */
    public Result<Long> createPesticidesCategory(PesticidesCategory pesticidesCategory);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    public Result<Integer> delete(Long id);

    /**
     * 修改农药类目信息
     * @param pesticidesCategory
     * @return
     */
    public Result<Integer> updatePesticidesCategory(PesticidesCategory pesticidesCategory);

    /**
     * 通过id查找农药类目信息
     *
     * @param id
     * @return
     */
    public Result<PesticidesCategory> findById(Long id);

    /**
     * 通过条件查询农药类目信息
     *
     * @param criteria
     * @return
     */
    public Result<List<PesticidesCategory>> queryPesticidesCategoryByCriteria(PesticidesCategoryCriteria criteria);
}
