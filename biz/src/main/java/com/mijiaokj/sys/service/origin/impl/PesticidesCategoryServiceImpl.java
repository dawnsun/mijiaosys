package com.mijiaokj.sys.service.origin.impl;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.origin.PesticidesCategoryRepository;
import com.mijiaokj.sys.dal.repository.query.origin.PesticidesCategoryCriteria;
import com.mijiaokj.sys.domain.origin.PesticidesCategory;
import com.mijiaokj.sys.service.origin.PesticidesCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/9/27.
 */
@Service
public class PesticidesCategoryServiceImpl implements PesticidesCategoryService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private PesticidesCategoryRepository pesticidesCategoryRepository;

    @Override
    public Result<Long> createPesticidesCategory(PesticidesCategory pesticidesCategory) {
        return null;
    }

    @Override
    public Result<Integer> delete(Long id) {
        return null;
    }

    @Override
    public Result<Integer> updatePesticidesCategory(PesticidesCategory pesticidesCategory) {
        return null;
    }

    @Override
    public Result<PesticidesCategory> findById(Long id) {
        return null;
    }

    @Override
    public Result<List<PesticidesCategory>> queryPesticidesCategoryByCriteria(PesticidesCategoryCriteria criteria) {
        return null;
    }
}
