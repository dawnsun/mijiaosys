package com.mijiaokj.sys.service;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.MemberType;

import java.util.List;

/**
 * Created by wb-scg178938 on 2017/7/3.
 */
public interface MemberTypeService {
    /**
     * 创建用户信息
     *
     * @param memberType
     * @return
     */
    public Result<Long> createMemberType(MemberType memberType);

    /**
     * update
     * @param memberType
     * @return
     */
    public Result<Integer> updateMemberType(MemberType memberType);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    public Result<Integer> delete(Long id);


    /**
     * 通过用户id查找用户
     *
     * @param id
     * @return
     */
    public Result<MemberType> findById(Long id);

    /**
     * 查询所有会员类型
     *
     * @param
     * @return
     */
    public Result<List<MemberType>> queryMemberTypeAll();
}
