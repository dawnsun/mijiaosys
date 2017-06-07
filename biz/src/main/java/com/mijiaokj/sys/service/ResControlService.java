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
}
