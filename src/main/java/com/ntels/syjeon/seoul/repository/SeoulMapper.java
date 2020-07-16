package com.ntels.syjeon.seoul.repository;

import com.ntels.syjeon.seoul.model.seoul.Row;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeoulMapper {

    void insert(Row row);
}
