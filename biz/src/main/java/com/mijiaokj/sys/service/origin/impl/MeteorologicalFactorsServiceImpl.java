package com.mijiaokj.sys.service.origin.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Page;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.origin.MeteorologicalFactorsRepository;
import com.mijiaokj.sys.dal.repository.query.origin.MeteorologicalFactorsCriteria;
import com.mijiaokj.sys.domain.origin.MeteorologicalFactors;
import com.mijiaokj.sys.service.origin.MeteorologicalFactorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-scg178938 on 2017/9/26.
 */
@Service
public class MeteorologicalFactorsServiceImpl implements MeteorologicalFactorsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MeteorologicalFactorsRepository meteorologicalFactorsRepository;

    @Override
    public Result<Long> createMeteorologicalFactors(MeteorologicalFactors meteorologicalFactors) {
        try {
            Preconditions.checkNotNull(meteorologicalFactors);
            Preconditions.checkNotNull(meteorologicalFactors.getLandId(), "LandId is null");
            Preconditions.checkNotNull(meteorologicalFactors.getIlluminationTime(), "IlluminationTime is null");
            Preconditions.checkNotNull(meteorologicalFactors.getPhotosyntheticIntensity(), "PhotosyntheticIntensity is null");
            Preconditions.checkNotNull(meteorologicalFactors.getPrecipitation(), "Precipitation is null");
            Preconditions.checkNotNull(meteorologicalFactors.getRelativeHumidity(), "RelativeHumidity is null");
            Preconditions.checkNotNull(meteorologicalFactors.getRespirationIntensity(), "RespirationIntensity is null");
            Preconditions.checkNotNull(meteorologicalFactors.getTemperature(), "Temperature is null");
            Preconditions.checkNotNull(meteorologicalFactors.getWindSpeed(), "WindSpeed is null");
            Preconditions.checkNotNull(meteorologicalFactors.getCreator(), "Creator is null");
            Preconditions.checkNotNull(meteorologicalFactors.getGmtCreate(), "GmtCreate is null");
            return Result.ofSuccess(meteorologicalFactorsRepository.insert(meteorologicalFactors));
        } catch (Exception e) {
            logger.error("MeteorologicalFactorsService createMeteorologicalFactors " + e);
            return Result.ofFail("create meteorologicalFactors fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> delete(Long id) {
        try {
            Preconditions.checkNotNull(id);
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(meteorologicalFactorsRepository.delete(id));
        } catch (Exception e) {
            logger.error("MeteorologicalFactorsService delete " + e);
            return Result.ofFail("delete meteorologicalFactors fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> updateMeteorologicalFactors(MeteorologicalFactors meteorologicalFactors) {
        try {
            Preconditions.checkNotNull(meteorologicalFactors);
            Preconditions.checkNotNull(meteorologicalFactors.getLandId(), "LandId is null");
            Preconditions.checkNotNull(meteorologicalFactors.getIlluminationTime(), "IlluminationTime is null");
            Preconditions.checkNotNull(meteorologicalFactors.getPhotosyntheticIntensity(), "PhotosyntheticIntensity is null");
            Preconditions.checkNotNull(meteorologicalFactors.getPrecipitation(), "Precipitation is null");
            Preconditions.checkNotNull(meteorologicalFactors.getRelativeHumidity(), "RelativeHumidity is null");
            Preconditions.checkNotNull(meteorologicalFactors.getRespirationIntensity(), "RespirationIntensity is null");
            Preconditions.checkNotNull(meteorologicalFactors.getTemperature(), "Temperature is null");
            Preconditions.checkNotNull(meteorologicalFactors.getWindSpeed(), "WindSpeed is null");
            Preconditions.checkNotNull(meteorologicalFactors.getCreator(), "Creator is null");
            Preconditions.checkNotNull(meteorologicalFactors.getGmtCreate(), "GmtCreate is null");
            Preconditions.checkNotNull(meteorologicalFactors.getModifier(), "Modifier is null");
            Preconditions.checkNotNull(meteorologicalFactors.getGmtModified(), "GmtModified is null");
            return Result.ofSuccess(meteorologicalFactorsRepository.update(meteorologicalFactors));
        } catch (Exception e) {
            logger.error("MeteorologicalFactorsService updateMeteorologicalFactors " + e);
            return Result.ofFail("update meteorologicalFactors fail:" + e.getMessage());
        }
    }

    @Override
    public Result<MeteorologicalFactors> findById(Long id) {
        try {
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(meteorologicalFactorsRepository.getById(id));
        } catch (Exception e) {
            logger.error("MeteorologicalFactorsService findById " + e);
            return Result.ofFail("findById meteorologicalFactors fail:" + e.getMessage());
        }
    }

    @Override
    public Result<List<MeteorologicalFactors>> queryMeteorologicalFactorsByLandId(Long landId, String date) {
        try {
            Preconditions.checkNotNull(landId, "landId is null");
            return Result.ofSuccess(meteorologicalFactorsRepository.queryMeteorologicalFactorsByLandId(landId,date));
        } catch (Exception e) {
            logger.error("MeteorologicalFactorsService queryMeteorologicalFactorsByLandId " + e);
            return Result.ofFail("queryMeteorologicalFactorsByLandId fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Page<MeteorologicalFactors>> queryMeteorologicalFactorsByCriteria(MeteorologicalFactorsCriteria criteria) {
        try {
            Preconditions.checkNotNull(criteria, "criteria is null");
            return Result.ofSuccess(meteorologicalFactorsRepository.executeQueryForPage(criteria));
        } catch (Exception e) {
            logger.error("MeteorologicalFactorsService queryMeteorologicalFactorsByCriteria " + e);
            return Result.ofFail("queryMeteorologicalFactorsByCriteria fail:" + e.getMessage());
        }
    }
}
