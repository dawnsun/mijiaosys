package com.mijiaokj.sys.service.origin.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.origin.LandQualityRepository;
import com.mijiaokj.sys.dal.repository.query.origin.LandQualityCriteria;
import com.mijiaokj.sys.domain.origin.LandQuality;
import com.mijiaokj.sys.service.origin.LandQualityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wb-scg178938 on 2017/9/22.
 */
@Service
public class LandQualityServiceImpl implements LandQualityService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private LandQualityRepository landQualityRepository;

    @Override
    public Result<Long> createLandQuality(LandQuality landQuality) {
        try {
            Preconditions.checkNotNull(landQuality);
            Preconditions.checkNotNull(landQuality.getLandId(), "landId is null");
            Preconditions.checkNotNull(landQuality.getPh(), "ph is null");
            Preconditions.checkNotNull(landQuality.getGmtTesting(), "gmtTesting is null");
            Preconditions.checkNotNull(landQuality.getCreator(), "Creator is null");
            Preconditions.checkNotNull(landQuality.getGmtCreate(), "GmtCreate is null");
            return Result.ofSuccess(landQualityRepository.insert(landQuality));
        } catch (Exception e) {
            logger.error("LandQualityService createLandQuality " + e);
            return Result.ofFail("create landQuality fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> delete(Long id) {
        try {
            Preconditions.checkNotNull(id);
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(landQualityRepository.delete(id));
        } catch (Exception e) {
            logger.error("LandQualityService delete " + e);
            return Result.ofFail("delete landQuality fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> updateLandQuality(LandQuality landQuality) {
        try {
            Preconditions.checkNotNull(landQuality);
            Preconditions.checkNotNull(landQuality.getId(), "id is null");
            Preconditions.checkNotNull(landQuality.getLandId(), "landId is null");
            Preconditions.checkNotNull(landQuality.getPh(), "ph is null");
            Preconditions.checkNotNull(landQuality.getGmtTesting(), "gmtTesting is null");
            Preconditions.checkNotNull(landQuality.getModifier(), "Modifier is null");
            Preconditions.checkNotNull(landQuality.getGmtModified(), "GmtModified is null");
            return Result.ofSuccess(landQualityRepository.update(landQuality));
        } catch (Exception e) {
            logger.error("LandQualityService updateLandQuality " + e);
            return Result.ofFail("update landQuality fail:" + e.getMessage());
        }
    }

    @Override
    public Result<LandQuality> findById(Long id) {
        try {
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(landQualityRepository.getById(id));
        } catch (Exception e) {
            logger.error("LandQualityService findById " + e);
            return Result.ofFail("findById landQuality fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Page<LandQuality>> queryLandQualityByCriteria(LandQualityCriteria criteria) {
        try {
            Preconditions.checkNotNull(criteria, "criteria is null");
            return Result.ofSuccess(landQualityRepository.executeQueryForPage(criteria));
        } catch (Exception e) {
            logger.error("LandQualityService queryLandQualityByCriteria " + e);
            return Result.ofFail("queryLandQualityByCriteria fail:" + e.getMessage());
        }
    }
}
