package com.mijiaokj.sys.dal.repository;

import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import com.mijiaokj.sys.dal.repository.mapper.SysMenuMapper;
import com.mijiaokj.sys.domain.SysMenu;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by sunchenguang on 2017/6/9.
 */
@Repository
public class SysMenuRepository extends BaseRepository<SysMenu> {
    @Resource
    SysMenuMapper sysMenuMapper;
    @Override
    protected BaseMapper<SysMenu> getMapper() {
        return this.sysMenuMapper;
    }

    /**
     * 查询所有菜单
     * @return
     */
    public List<SysMenu> getAllMenu(){
        return sysMenuMapper.getAllMenu();
    }

    /**
     * 主键In查询菜单
     * @param map
     * @return
     */
    List<SysMenu> getMenuByIds(Map<String, Object> map){
        return sysMenuMapper.getMenuByIds(map);
    }
}
