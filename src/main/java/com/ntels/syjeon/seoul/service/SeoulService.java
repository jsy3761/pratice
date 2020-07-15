package com.ntels.syjeon.seoul.service;

import com.google.gson.Gson;
import com.ntels.syjeon.seoul.model.SeoulResult;
import com.ntels.syjeon.seoul.model.seoul.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeoulService {
    private static final Logger logger = LoggerFactory.getLogger(SeoulService.class);

    /**
     * 서버 구동시 최초 1회 Api 호출 loadData();
     * 
     * 생성자 주입
     * @param apiService
     */
    public SeoulService(ApiService apiService) {
        this.apiService = apiService;
        loadData();
        logger.debug("AllData Size : {}", rowList.size());
    }

    private ApiService apiService;
    private List<Row> rowList = new ArrayList<>();
    private int dataSize = 26;


    /**
     * 기간을 입력 받아 서울시 인구 현황 리스트를 반환하는 메서드
     * @param gigan
     * @return
     */
    public List<Row> getRowsByGigan(String gigan) {
        logger.debug("RowList Size : [{}]", rowList.size());
        List<Row> resultRow = new ArrayList<>();

        rowList.forEach(row -> {
            if (row.getGIGAN().equals(gigan)) {
                resultRow.add(row);
            }
        });

        logger.debug("resultRow Size : [{}]", resultRow.size());
        return resultRow;
    }

    /**
     * 자치구 이름을 인자로 받아 해당자치구를 검색하여 반환하는 메서드
     * 기간 기준은 최신으로 검색
     * @param jachigu 자치구 이름
     */
    public Row findByJachiguRecent(String jachigu, String gigan) {
        Row row = rowList.stream().filter(r -> {
            return r.getGIGAN().equals(gigan) && r.getJACHIGU().equals(jachigu);
        }).collect(Collectors.toList()).get(0);

        return row;
    }


    /**
     * 자치구리스트 데이터 추출 메소드
     */
    public List<String> getJachiguList() {
        List<String> jachiguList = new ArrayList<>();
        for (int i = 0; i < dataSize; i++) {
            jachiguList.add(rowList.get(i).getJACHIGU());
        }
        return jachiguList;
    }

    /**
     * 서버 최초 구동시 인구데이터 Api를 호출하는 메서드
     * 총 데이터 갯수 1067 , 한번에 1000건 조회가능, 2번 나눠서 호출후 List 저장
     */
    public void loadData() {
        String json = apiService.getApi(1, 1000);
        rowList = new Gson().fromJson(json, SeoulResult.class).getOctastatapi419().getRow();

        json = apiService.getApi(1001, 1067);
        List<Row> rowList1 = new Gson().fromJson(json, SeoulResult.class).getOctastatapi419().getRow();

        rowList1.forEach(r -> {
            rowList.add(r);
        });
    }
}
