package com.mijiaokj.sys.service.origin;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.origin.LandRes;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/9/22.
 * 土地资源信息管理
 */
public interface LandResService {
    /**
     * 创建土地资源信息
     * @param landRes
     * @return
     */
    public Result<Long> createLandRes(LandRes landRes);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    public Result<Integer> delete(Long id);

    /**
     * 修改土地资源信息
     * @param landRes
     * @return
     */
    public Result<Integer> updateLandRes(LandRes landRes);

    /**
     * 通过id查找土地资源信息
     *
     * @param id
     * @return
     */
    public Result<LandRes> findById(Long id);

    /**
     * 通过创建人查询所有土地资源
     *
     * @param creator
     * @return
     */
    public Result<List<LandRes>> queryLandResByCreator(String creator);
}
