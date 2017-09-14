package com.mijiaokj.sys.service.origin.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.origin.CropsOperationRepository;
import com.mijiaokj.sys.domain.origin.CropsOperation;
import com.mijiaokj.sys.service.origin.CropsOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/9/14.
 */
@Service
public class CropsOperationServiceImpl implements CropsOperationService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CropsOperationRepository cropsOperationRepository;

    @Override
    public Result<Long> createCropsOperation(CropsOperation cropsOperation) {
        try {
            Preconditions.checkNotNull(cropsOperation);
            Preconditions.checkNotNull(cropsOperation.getCropsId(), "CropsId is null");
            Preconditions.checkNotNull(cropsOperation.getOperationName(), "OperationName is null");
            Preconditions.checkNotNull(cropsOperation.getMainOperation(), "MainOperation is null");
            Preconditions.checkNotNull(cropsOperation.getOperationOrder(), "CropsOrder is null");
            Preconditions.checkNotNull(cropsOperation.getCreator(), "Creator is null");
            Preconditions.checkNotNull(cropsOperation.getGmtCreate(), "GmtCreate is null");
            return Result.ofSuccess(cropsOperationRepository.insert(cropsOperation));
        } catch (Exception e) {
            logger.error("CropsOperationService createCropsOperation " + e);
            return Result.ofFail("create cropsOperation fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> delete(Long id) {
        try {
            Preconditions.checkNotNull(id);
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(cropsOperationRepository.delete(id));
        } catch (Exception e) {
            logger.error("CropsOperationService delete " + e);
            return Result.ofFail("delete cropsOperation fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> updateCropsOperation(CropsOperation cropsOperation) {
        try {
            Preconditions.checkNotNull(cropsOperation);
            Preconditions.checkNotNull(cropsOperation.getCropsId(), "CropsId is null");
            Preconditions.checkNotNull(cropsOperation.getOperationName(), "OperationName is null");
            Preconditions.checkNotNull(cropsOperation.getMainOperation(), "MainOperation is null");
            Preconditions.checkNotNull(cropsOperation.getOperationOrder(), "CropsOrder is null");
            Preconditions.checkNotNull(cropsOperation.getModifier(), "Modifier is null");
            Preconditions.checkNotNull(cropsOperation.getGmtModified(), "GmtModified is null");
            return Result.ofSuccess(cropsOperationRepository.update(cropsOperation));
        } catch (Exception e) {
            logger.error("CropsOperationService updateCropsOperation " + e);
            return Result.ofFail("update cropsOperation fail:" + e.getMessage());
        }
    }

    @Override
    public Result<CropsOperation> findById(Long id) {
        try {
            Preconditions.checkNotNull(id);
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(cropsOperationRepository.getById(id));
        } catch (Exception e) {
            logger.error("CropsOperationService findById " + e);
            return Result.ofFail("findById cropsOperation fail:" + e.getMessage());
        }
    }

    @Override
    public Result<List<CropsOperation>> findListByCropsId(Long cropsId) {
        try {
            Preconditions.checkNotNull(cropsId);
            Preconditions.checkNotNull(cropsId, "cropsId is null");
            return Result.ofSuccess(cropsOperationRepository.findListByCropsId(cropsId));
        } catch (Exception e) {
            logger.error("CropsOperationService findListByCropsId " + e);
            return Result.ofFail("findListByCropsId cropsOperation fail:" + e.getMessage());
        }
    }
}
