package com.mijiaokj.sys.dal.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mijiaokj.sys.domain.ResControl;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: ResControlMapper
 * @Description: TODO 资源操作映射
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月14日
 *
 */
@Mapper
public interface ResControlMapper extends BaseMapper<ResControl> {
    /**
     * 获取所有的系统资源
     * @return
     */
    List<ResControl> getAllResControl();

    /**
     * 通过map中封装idIn查询资源
     * @param map
     * @return
     */
    List<ResControl> getControlByIds(Map<String, Object> map);
}