package com.mijiaokj.sys.service;

import com.mijiaokj.sys.common.util.Result;
import com.mijiaokj.sys.domain.ResControl;

import java.util.List;

/**
 * Created by sunchenguang on 2017/6/6.
 */
public interface ResControlService {
    /**
     * 查询所有有效的权限操作资源
     * @return
     */
    public Result<List<ResControl>> getAllResControl();
}
