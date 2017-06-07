package com.mijiaokj.sys.service.impl;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.ResControlRepository;
import com.mijiaokj.sys.domain.ResControl;
import com.mijiaokj.sys.service.ResControlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunchenguang on 2017/6/6.
 */
@Service("resControlService")
public class ResControlServiceImpl implements ResControlService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ResControlRepository resMethedRepository;
    @Override
    public Result<List<ResControl>> getAllResControl() {
        try {
            List<ResControl> l = resMethedRepository.getAllResControl();
            return Result.ofSuccess(l);
        } catch (Exception e) {
            logger.error("resMethedService " + e);
            return Result.ofFail("getAllResMethed fail:" + e.getMessage());
        }
    }
}
