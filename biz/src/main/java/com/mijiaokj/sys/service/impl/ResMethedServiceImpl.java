package com.mijiaokj.sys.service.impl;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.ResMethedRepository;
import com.mijiaokj.sys.domain.ResMethed;
import com.mijiaokj.sys.service.ResMethedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunchenguang on 2017/6/6.
 */
@Service("resMethedService")
public class ResMethedServiceImpl implements ResMethedService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ResMethedRepository resMethedRepository;
    @Override
    public Result<List<ResMethed>> getAllResMethed() {
        try {
            List<ResMethed> l = resMethedRepository.getAllResMethed();
            return Result.ofSuccess(l);
        } catch (Exception e) {
            logger.error("resMethedService " + e);
            return Result.ofFail("getAllResMethed fail:" + e.getMessage());
        }
    }
}
