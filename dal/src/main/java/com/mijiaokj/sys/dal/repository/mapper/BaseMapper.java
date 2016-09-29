package com.mijiaokj.sys.dal.repository.mapper;

import com.mijiaokj.sys.domain.BaseDomainObject;

public interface BaseMapper<T extends BaseDomainObject> {

	int insert(T domain);

	T getById(Long id);

	void delete(Long id);

	void update(T domain);
}
