package com.mijiaokj.sys.dal.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mijiaokj.sys.domain.ResMethed;

import java.util.List;

/**
 * 
 * @ClassName: ResMethedMapper
 * @Description: TODO 资源操作映射
 * @author sunchenguang
 * @eamil scg16@126.com
 * @date 2016年10月14日
 *
 */
@Mapper
public interface ResMethedMapper extends BaseMapper<ResMethed> {
    /**
     * 获取所有的系统资源
     * @return
     */
    List<ResMethed> getAllResMethed();
}