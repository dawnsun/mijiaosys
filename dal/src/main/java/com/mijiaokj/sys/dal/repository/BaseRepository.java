package com.mijiaokj.sys.dal.repository;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.domain.ReferenceObject;

public abstract class BaseRepository<T extends ReferenceObject> {
	protected abstract BaseMapper<T> getMapper();

	/**
	 * @param domain
	 *
	 * @return ID
	 */
	public Long insert(T domain) {
		Preconditions.checkNotNull(domain, domain.getClass().getSimpleName() + " is null");
		domain.setDefaultValue();

		getMapper().insert(domain);
		return domain.getId();
	}

	public T getById(Long id) {
		return getMapper().getById(id);
	}

	public void delete(Long id) {
		getMapper().delete(id);
	}

	protected void checkIdNotNull(T domain) {
		String clazzName = domain.getClass().getSimpleName();
		Preconditions.checkNotNull(domain, clazzName + " is null");
		Preconditions.checkNotNull(domain.getId(), clazzName + ".id is null");
	}
}
