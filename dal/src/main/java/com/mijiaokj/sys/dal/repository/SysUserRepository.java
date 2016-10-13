package com.mijiaokj.sys.dal.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.mijiaokj.sys.common.util.PageData;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.SysUserMapper;
import com.mijiaokj.sys.dal.repository.query.SysUserCriteria;
import com.mijiaokj.sys.domain.SysUser;

/**
 * 
 * @ClassName: LoginController
 * @Description: TODO 系统用户操作，使用cache
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月13日
 *
 */
@Repository
@CacheConfig(cacheNames = "sysUser")
public class SysUserRepository extends BaseRepository<SysUser> {
	@Resource
    private SysUserMapper sysUserMapper;
	
	@Cacheable
	public SysUser findByUsername(String username){
		return sysUserMapper.findByUsername(username);
	}

	public PageData<SysUser> executeQueryForPage(SysUserCriteria criteria){
		List<SysUser> datas = sysUserMapper.selectPageByMap(criteria);
		Integer count = sysUserMapper.pageCountByMap(criteria);
		return new PageData<>(datas, criteria.getStartRow(), criteria.getPageSize(), count);
	}
	
	@Override
	protected BaseMapper<SysUser> getMapper() {
		return this.sysUserMapper;
	}

}
