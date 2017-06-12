package com.mijiaokj.sys.service;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/11.
 */
public interface SysMenuService {
    /**
     * 通过主键In查询 用于关联关系的查询展示
     * @param map
     * @return
     */
    public Result<List<SysMenu>> getMenuByIds(Map<String, Object> map);

    /**
     * 创建菜单项
     * @param sysMenu
     * @return
     */
    public Result<Long> createMenu(SysMenu sysMenu);

    /**
     * 更新菜单
     * @param sysMenu
     * @return
     */
    public Result<Integer> updateMenu(SysMenu sysMenu);

    /**
     * 通过主键删除菜单
     * @param id
     * @return
     */
    public Result<Integer> deleteMenu(Long id);

    /**
     * 查询所有的菜单
     * @return
     */
    public Result<List<SysMenu>> getAllMenu();
}

