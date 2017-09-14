package com.mijiaokj.sys.service.origin.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.origin.CropsRepository;
import com.mijiaokj.sys.domain.origin.Crops;
import com.mijiaokj.sys.service.origin.CropsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/9/14.
 */
@Service
public class CropsServiceImpl implements CropsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CropsRepository cropsRepository;

    @Override
    public Result<Long> createCrops(Crops crops) {
        try {
            Preconditions.checkNotNull(crops);
            Preconditions.checkNotNull(crops.getParentId(), "ParentId is null");
            Preconditions.checkNotNull(crops.getCropsName(), "CropsName is null");
            Preconditions.checkNotNull(crops.getCropsIcon(), "CropsIcon is null");
            Preconditions.checkNotNull(crops.getCropsOrder(), "CropsOrder is null");
            Preconditions.checkNotNull(crops.getCreator(), "Creator is null");
            Preconditions.checkNotNull(crops.getGmtCreate(), "GmtCreate is null");
            return Result.ofSuccess(cropsRepository.insert(crops));
        } catch (Exception e) {
            logger.error("CropsService createCrops " + e);
            return Result.ofFail("create crops fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> delete(Long id) {
        try {
            Preconditions.checkNotNull(id);
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(cropsRepository.delete(id));
        } catch (Exception e) {
            logger.error("CropsService delete " + e);
            return Result.ofFail("delete crops fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> updateCrops(Crops crops) {
        try {
            Preconditions.checkNotNull(crops);
            Preconditions.checkNotNull(crops.getParentId(), "ParentId is null");
            Preconditions.checkNotNull(crops.getCropsName(), "CropsName is null");
            Preconditions.checkNotNull(crops.getCropsIcon(), "CropsIcon is null");
            Preconditions.checkNotNull(crops.getCropsOrder(), "CropsOrder is null");
            Preconditions.checkNotNull(crops.getModifier(), "Modifier is null");
            Preconditions.checkNotNull(crops.getGmtModified(), "GmtModified is null");
            return Result.ofSuccess(cropsRepository.update(crops));
        } catch (Exception e) {
            logger.error("CropsService updateCrops " + e);
            return Result.ofFail("update crops fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Crops> findById(Long id) {
        try {
            Preconditions.checkNotNull(id);
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(cropsRepository.getById(id));
        } catch (Exception e) {
            logger.error("CropsService findById " + e);
            return Result.ofFail("findById crops fail:" + e.getMessage());
        }
    }

    @Override
    public Result<List<Crops>> findListByParentId(Long parentId) {
        try {
            Preconditions.checkNotNull(parentId);
            Preconditions.checkNotNull(parentId, "parentId is null");
            return Result.ofSuccess(cropsRepository.findListByParentId(parentId));
        } catch (Exception e) {
            logger.error("CropsService findListByParentId " + e);
            return Result.ofFail("findListByParentId crops fail:" + e.getMessage());
        }
    }

    @Override
    public Result<List<Crops>> findListByCropsName(String cropsName) {
        try {
            Preconditions.checkNotNull(cropsName);
            Preconditions.checkNotNull(cropsName, "cropsName is null");
            return Result.ofSuccess(cropsRepository.findListByCropsName(cropsName));
        } catch (Exception e) {
            logger.error("CropsService findListByCropsName " + e);
            return Result.ofFail("findListByCropsName crops fail:" + e.getMessage());
        }
    }
}
