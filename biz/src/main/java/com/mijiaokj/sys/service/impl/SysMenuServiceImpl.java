package com.mijiaokj.sys.service.impl;

import com.google.common.base.Preconditions;
import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.dal.repository.SysMenuRepository;
import com.mijiaokj.sys.dal.repository.SysRoleRepository;
import com.mijiaokj.sys.domain.ResControl;
import com.mijiaokj.sys.domain.SysMenu;
import com.mijiaokj.sys.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 *  爱一个人好难 好老的歌啊 就这么喜欢孤单
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private SysMenuRepository sysMenuRepository;

    @Override
    public Result<List<SysMenu>> getMenuByIds(Map<String, Object> map) {
        try {
            Preconditions.checkNotNull(map);
            List<SysMenu> l = sysMenuRepository.getMenuByIds(map);
            return Result.ofSuccess(l);
        } catch (Exception e) {
            logger.error("getMenuByIds " + e);
            return Result.ofFail("getMenuByIds fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Long> createMenu(SysMenu sysMenu) {
        try {
            Preconditions.checkNotNull(sysMenu);
            Long l = sysMenuRepository.insert(sysMenu);
            return Result.ofSuccess(l);
        } catch (Exception e) {
            logger.error("createMenu " + e);
            return Result.ofFail("createMenu fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> updateMenu(SysMenu sysMenu) {
        try {
            Preconditions.checkNotNull(sysMenu);
            Integer l = sysMenuRepository.update(sysMenu);
            return Result.ofSuccess(l);
        } catch (Exception e) {
            logger.error("updateMenu " + e);
            return Result.ofFail("updateMenu fail:" + e.getMessage());
        }
    }

    @Override
    public Result<Integer> deleteMenu(Long id) {
        try {
            Preconditions.checkNotNull(id);
            Integer l = sysMenuRepository.delete(id);
            return Result.ofSuccess(l);
        } catch (Exception e) {
            logger.error("deleteMenu " + e);
            return Result.ofFail("deleteMenu fail:" + e.getMessage());
        }
    }

    @Override
    public Result<List<SysMenu>> getAllMenu() {
        try {
            List<SysMenu> l = sysMenuRepository.getAllMenu();
            return Result.ofSuccess(l);
        } catch (Exception e) {
            logger.error("getAllMenu " + e);
            return Result.ofFail("getAllMenu fail:" + e.getMessage());
        }
    }
}
