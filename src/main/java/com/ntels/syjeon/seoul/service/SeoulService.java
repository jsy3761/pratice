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

    public SeoulService(ApiService apiService) {
        this.apiService = apiService;
        loadData();
        logger.debug("AllData Size : {}", rowList.size());
    }
    private static final Logger logger = LoggerFactory.getLogger(SeoulService.class);
    private ApiService apiService;
    private List<Row> rowList = new ArrayList<>();
    private int dataSize = 26;

    public List<Row> getRowsByGigan(String gigan) {
        logger.debug("RowList Size : [{}]", rowList.size());
        List<Row> resultRow = new ArrayList<>();

        rowList.forEach(row -> {
            if (row.getGIGAN().equals(gigan)){
                resultRow.add(row);
            }
        });
        logger.debug("resultRow Size : [{}]", resultRow.size());
        return resultRow;
    }

    public Row findByJachiguRecent(String jachigu) {
        Row row = rowList.stream().filter(r -> {
           return r.getGIGAN().equals("2020.1-4") && r.getJACHIGU().equals(jachigu) ;
        }).collect(Collectors.toList()).get(0);

        return row;
    }

    public List<String> getJachiguList() {
        List<String> jachiguList = new ArrayList<>();
        for (int i = 0; i < dataSize; i++) {
            jachiguList.add(rowList.get(i).getJACHIGU());
        }
        return jachiguList;
    }
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
