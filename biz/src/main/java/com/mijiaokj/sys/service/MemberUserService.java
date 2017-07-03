package com.mijiaokj.sys.service;

import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.query.MemberUserCriteria;
import com.mijiaokj.sys.domain.MemberUser;

/**
 * Created by wb-scg178938 on 2017/7/3.
 */
public interface MemberUserService {
    /**
     * 创建用户信息
     *
     * @param memberUser
     * @return
     */
    public Result<Long> createMemberUser(MemberUser memberUser);

    /**
     * update
     * @param memberUser
     * @return
     */
    public Result<Integer> updateMemberUser(MemberUser memberUser);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    public Result<Integer> delete(Long id);

    /**
     * 通过用户名查找用户
     *
     * @param memberName
     * @return
     */
    public Result<MemberUser> findByMemberUser(String memberName);

    /**
     * 通过用户id查找用户
     *
     * @param id
     * @return
     */
    public Result<MemberUser> findById(Long id);

    /**
     * 条件查询，分页查询
     *
     * @param criteria
     * @return
     */
    public Result<Page<MemberUser>> queryMemberUserByCriteria(MemberUserCriteria criteria);

    /**
     *
     * @param phoneNumber
     * @return
     */
    public Result<MemberUser> findByPhoneNumber(String phoneNumber);

}
