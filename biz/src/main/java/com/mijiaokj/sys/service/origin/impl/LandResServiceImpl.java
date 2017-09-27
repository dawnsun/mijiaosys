package com.mijiaokj.sys.service.origin.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.origin.LandResRepository;
import com.mijiaokj.sys.domain.origin.LandRes;
import com.mijiaokj.sys.service.origin.LandResService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/9/22.
 */
@Service
public class LandResServiceImpl implements LandResService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private LandResRepository landResRepository;

    @Override
    public Result<Long> createLandRes(LandRes landRes) {
        try {
            Preconditions.checkNotNull(landRes);
            Preconditions.checkNotNull(landRes.getAlias(), "alias is null");
            Preconditions.checkNotNull(landRes.getAltitude(), "altitude is null");
            Preconditions.checkNotNull(landRes.getLatitude(), "Latitude is null");
            Preconditions.checkNotNull(landRes.getLongitude(), "Longitude is null");
            Preconditions.checkNotNull(landRes.getCreator(), "Creator is null");
            Preconditions.checkNotNull(landRes.getGmtCreate(), "GmtCreate is null");
            return Result.ofSuccess(landResRepository.insert(landRes));
        } catch (Exception e) {
            logger.error("LandResService createLandRes " + e);
            return Result.ofFail("create landRes fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> delete(Long id) {
        try {
            Preconditions.checkNotNull(id);
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(landResRepository.delete(id));
        } catch (Exception e) {
            logger.error("LandResService delete " + e);
            return Result.ofFail("delete landRes fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> updateLandRes(LandRes landRes) {
        try {
            Preconditions.checkNotNull(landRes);
            Preconditions.checkNotNull(landRes.getAlias(), "alias is null");
            Preconditions.checkNotNull(landRes.getAltitude(), "altitude is null");
            Preconditions.checkNotNull(landRes.getLatitude(), "Latitude is null");
            Preconditions.checkNotNull(landRes.getLongitude(), "Longitude is null");
            Preconditions.checkNotNull(landRes.getCreator(), "Creator is null");
            Preconditions.checkNotNull(landRes.getGmtCreate(), "GmtCreate is null");
            Preconditions.checkNotNull(landRes.getModifier(), "Modifier is null");
            Preconditions.checkNotNull(landRes.getGmtModified(), "GmtModified is null");
            return Result.ofSuccess(landResRepository.update(landRes));
        } catch (Exception e) {
            logger.error("LandResService updateLandRes " + e);
            return Result.ofFail("update landRes fail:" + e.getMessage());
        }
    }

    @Override
    public Result<LandRes> findById(Long id) {
        try {
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(landResRepository.getById(id));
        } catch (Exception e) {
            logger.error("LandResService findById " + e);
            return Result.ofFail("findById landQuality fail:" + e.getMessage());
        }
    }

    @Override
    public Result<List<LandRes>> queryLandResByCreator(String creator) {
        try {
            Preconditions.checkNotNull(creator, "creator is null");
            return Result.ofSuccess(landResRepository.queryLandResByCreator(creator));
        } catch (Exception e) {
            logger.error("LandResService findById " + e);
            return Result.ofFail("findById landQuality fail:" + e.getMessage());
        }
    }
}
