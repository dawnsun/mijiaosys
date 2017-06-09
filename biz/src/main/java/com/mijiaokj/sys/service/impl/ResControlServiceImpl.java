package com.mijiaokj.sys.service.impl;

import com.google.common.base.Preconditions;
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

    @Override
    public Result<Long> createResControl(ResControl resControl) {
        try {
            Preconditions.checkNotNull(resControl);
            Preconditions.checkNotNull(resControl.getControlName(), "ControlName is null");
            Preconditions.checkNotNull(resControl.getControlUrl(), "ControlUrl is null");
            Preconditions.checkNotNull(resControl.getCreator(), "creator is null");
            Preconditions.checkNotNull(resControl.getModifier(), "modifier is null");
            return Result.ofSuccess(resControlRepository.insert(resControl));
        } catch (Exception e) {
            logger.error("createResControl " + e);
            return Result.ofFail("createResControl fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> updateResContorl(ResControl resControl) {
        try {
            Preconditions.checkNotNull(resControl);
            Preconditions.checkNotNull(resControl.getControlName(), "ControlName is null");
            Preconditions.checkNotNull(resControl.getControlUrl(), "ControlUrl is null");
            Preconditions.checkNotNull(resControl.getCreator(), "creator is null");
            Preconditions.checkNotNull(resControl.getModifier(), "modifier is null");
            return Result.ofSuccess(resControlRepository.update(resControl));
        } catch (Exception e) {
            logger.error("updateResContorl " + e);
            return Result.ofFail("updateResContorl fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> deleteResControl(Long id) {
        try {
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(resControlRepository.delete(id));
        } catch (Exception e) {
            logger.error("deleteResControl " + e);
            return Result.ofFail("deleteResControl fail:" + e.getMessage());
        }
    }

    @Override
    public Result<ResControl> findResControlById(Long id) {
        try {
            Preconditions.checkNotNull(id, "id is null");
            return Result.ofSuccess(resControlRepository.getById(id));
        } catch (Exception e) {
            logger.error("findResControlById " + e);
            return Result.ofFail("findResControlById fail:" + e.getMessage());
        }
    }
}
