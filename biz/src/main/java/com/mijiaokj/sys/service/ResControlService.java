package com.mijiaokj.sys.service;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.ResControl;

import java.util.List;
import java.util.Map;

/**
 * Created by sunchenguang on 2017/6/6.
 * 权限资源操作服务接口
 */
public interface ResControlService {
    /**
     * 查询所有有效的权限操作资源
     * @return
     */
    public Result<List<ResControl>> getAllResControl();

    /**
     * 通过多主键查询列表
     * @param map
     * @return
     */
    public Result<List<ResControl>> getControlByIds(Map<String, Object> map);

    /**
     * 创建权限资源
     * @param resControl
     * @return
     */
    public Result<Long> createResControl(ResControl resControl);

    /**
     * 更新权限资源
     * @param resControl
     * @return
     */
    public Result<Integer> updateResContorl(ResControl resControl);

    /**
     * 删除资源权限
     * @param id
     * @return
     */
    public Result<Integer> deleteResControl(Long id);

    /**
     * 通过主键查
     * @param id
     * @return
     */
    public  Result<ResControl> findResControlById(Long id);
}
