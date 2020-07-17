package com.ntels.syjeon.seoul.dao;

import com.ntels.syjeon.seoul.model.seoul.Row;
import org.apache.ibatis.annotations.Mapper;

/**
 * Seoul Mapper
 * @author syjeon@ntels.com
 */
@Mapper
public interface SeoulMapper {

    /**
     * 자치구 모델 1건 저장
     * @param row
     */
    void insert(Row row);
}
