package com.mijiaokj.sys.dal.repository.mapper;

import com.mijiaokj.sys.domain.BaseDomainObject;
/**
 * 
 * @ClassName: BaseMapper
 * @Description: TODO 基础操作方法接口
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月14日
 *
 */
public interface BaseMapper<T extends BaseDomainObject> {

	int insert(T domain);

	T getById(Long id);

	void delete(Long id);

	void update(T domain);
}
