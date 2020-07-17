package com.ntels.syjeon.seoul.service;

import com.ntels.syjeon.seoul.model.seoul.Row;

import java.util.List;

/**
 * Seoul Service
 * @author syjeon@ntels.com
 */
public interface SeoulService {

    /**
     * 서울시 자치구 리스트 조회
     * @return 서울시 25개 자치구 리스트
     */
    List<Row> getRowsList();

    /**
     * 서울시 자치구 단건 조회
     * @param gigan 조회기간
     * @param jachigu 자치구 이름
     * @return 자치구 모델 Row
     */
    Row getRow(String gigan, String jachigu);

}
