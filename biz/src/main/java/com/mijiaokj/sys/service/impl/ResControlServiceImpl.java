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
import java.util.Map;

/**
 * Created by sunchenguang on 2017/6/6.
 * 权限资源操作服务实现类
 */
@Service("resControlService")
public class ResControlServiceImpl implements ResControlService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ResControlRepository resControlRepository;

    @Override
    public Result<List<ResControl>> getAllResControl() {
        try {
            List<ResControl> l = resControlRepository.getAllResControl();
            return Result.ofSuccess(l);
        } catch (Exception e) {
            logger.error("getAllResControl " + e);
            return Result.ofFail("getAllResControl fail:" + e.getMessage());
        }
    }

    @Override
    public Result<List<ResControl>> getControlByIds(Map<String, Object> map){
        try {
            List<ResControl> l = resControlRepository.getControlByIds(map);
            return Result.ofSuccess(l);
        } catch (Exception e) {
            logger.error("getControlByIds " + e);
            return Result.ofFail("getControlByIds fail:" + e.getMessage());
        }
    }
}
