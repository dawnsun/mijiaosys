package com.mijiaokj.sys.service.origin.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.origin.DailyOperationRepository;
import com.mijiaokj.sys.dal.repository.query.origin.DailyOperationCriteria;
import com.mijiaokj.sys.domain.origin.DailyOperation;
import com.mijiaokj.sys.service.origin.DailyOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wb-scg178938 on 2017/9/22.
 */
@Service
public class DailyOperationServiceImpl implements DailyOperationService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private DailyOperationRepository dailyOperationRepository;

    @Override
    public Result<Long> createDailyOperation(DailyOperation dailyOperation) {
        try {
            Preconditions.checkNotNull(dailyOperation);
            Preconditions.checkNotNull(dailyOperation.getCropsId(), "CropsId is null");
            Preconditions.checkNotNull(dailyOperation.getLandId(), "landId is null");
            Preconditions.checkNotNull(dailyOperation.getUserId(), "userId is null");
            Preconditions.checkNotNull(dailyOperation.getOperationId(), "operationId is null");
            Preconditions.checkNotNull(dailyOperation.getPests(), "Pests is null");
            Preconditions.checkNotNull(dailyOperation.getCreator(), "Creator is null");
            Preconditions.checkNotNull(dailyOperation.getGmtCreate(), "GmtCreate is null");
            return Result.ofSuccess(dailyOperationRepository.insert(dailyOperation));
        } catch (Exception e) {
            logger.error("DailyOperationService createDailyOperation " + e);
            return Result.ofFail("create dailyOperation fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> delete(Long id) {
        try {
            Preconditions.checkNotNull(id);
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(dailyOperationRepository.delete(id));
        } catch (Exception e) {
            logger.error("DailyOperationService delete " + e);
            return Result.ofFail("delete dailyOperation fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> updateDailyOperation(DailyOperation dailyOperation) {
        try {
            Preconditions.checkNotNull(dailyOperation);
            Preconditions.checkNotNull(dailyOperation.getCropsId(), "CropsId is null");
            Preconditions.checkNotNull(dailyOperation.getLandId(), "landId is null");
            Preconditions.checkNotNull(dailyOperation.getUserId(), "userId is null");
            Preconditions.checkNotNull(dailyOperation.getOperationId(), "operationId is null");
            Preconditions.checkNotNull(dailyOperation.getPests(), "Pests is null");
            Preconditions.checkNotNull(dailyOperation.getModifier(), "Modifier is null");
            Preconditions.checkNotNull(dailyOperation.getGmtModified(), "GmtModified is null");
            return Result.ofSuccess(dailyOperationRepository.update(dailyOperation));
        } catch (Exception e) {
            logger.error("DailyOperationService updateDailyOperation " + e);
            return Result.ofFail("update dailyOperation fail:" + e.getMessage());
        }
    }

    @Override
    public Result<DailyOperation> findById(Long id) {
        try {
            Preconditions.checkNotNull(id);
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(dailyOperationRepository.getById(id));
        } catch (Exception e) {
            logger.error("DailyOperationService findById " + e);
            return Result.ofFail("findById dailyOperation fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Page<DailyOperation>> queryDailyOperationByCriteria(DailyOperationCriteria criteria) {
        try {
            Preconditions.checkNotNull(criteria, "criteria is null");
            return Result.ofSuccess(dailyOperationRepository.executeQueryForPage(criteria));
        } catch (Exception e) {
            logger.error("DailyOperationService queryDailyOperationByCriteria " + e);
            return Result.ofFail("queryDailyOperationByCriteria fail:" + e.getMessage());
        }
    }
}
