package com.mijiaokj.sys.service;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.ResMethed;

import java.util.List;

/**
 * Created by sunchenguang on 2017/6/6.
 */
public interface ResMethedService {
    /**
     * 查询所有有效的权限操作资源
     * @return
     */
    public Result<List<ResMethed>> getAllResMethed();
}
