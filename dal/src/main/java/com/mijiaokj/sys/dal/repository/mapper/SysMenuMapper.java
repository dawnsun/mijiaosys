package com.mijiaokj.sys.dal.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mijiaokj.sys.domain.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: SysMenuMapper
 * @Description: TODO 资源菜单表关系映射
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月14日
 *
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 获取所有的菜单
     * @return
     */
    List<SysMenu> getAllMenu();

    /**
     * 通过菜单主键IN查询
     * @param map
     * @return
     */
    List<SysMenu> getMenuByIds(Map<String, Object> map);
}