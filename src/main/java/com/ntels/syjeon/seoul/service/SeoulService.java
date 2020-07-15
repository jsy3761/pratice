package com.ntels.syjeon.seoul.service;

import com.google.gson.Gson;
import com.ntels.syjeon.seoul.model.SeoulResult;
import com.ntels.syjeon.seoul.model.seoul.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeoulService {
    public SeoulService(ApiService apiService){
        this.apiService = apiService;
        this.apiJsonString = apiService.getApi();
    }

    private static final Logger logger = LoggerFactory.getLogger(SeoulService.class);

    private ApiService apiService;
    private String apiJsonString;

    public List<Row> getSeoulPeople(){
        String json = apiJsonString;
        SeoulResult seoulResult = new Gson().fromJson(json, SeoulResult.class);

        List<Row> rowList = seoulResult.getOctastatapi419().getRow();

        logger.debug("RowList Size : [{}]", rowList.size());

        return rowList;
    }


    public Row findByJachigu(String jachigu){
        String json = apiJsonString;
        SeoulResult seoulResult = new Gson().fromJson(json, SeoulResult.class);
        List<Row> rowList = seoulResult.getOctastatapi419().getRow();

        Row row = rowList.stream().filter(r -> {
            return r.getJACHIGU().equals(jachigu);
        }).collect(Collectors.toList()).get(0);

        logger.debug("@Params : [{}]   Result : [{}]",jachigu, row);

        return row;
    }
}
