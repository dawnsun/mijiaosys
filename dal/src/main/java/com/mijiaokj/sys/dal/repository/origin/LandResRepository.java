package com.mijiaokj.sys.dal.repository.origin;

import com.mijiaokj.sys.dal.repository.BaseRepository;
import com.mijiaokj.sys.dal.repository.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by wb-scg178938 on 2017/8/7.
 * 土地资源Repository
 * 农户维护自己的土地信息
 */
@Repository
public class LandResRepository extends BaseRepository {
    @Override
    protected BaseMapper getMapper() {
        return null;
    }
}
