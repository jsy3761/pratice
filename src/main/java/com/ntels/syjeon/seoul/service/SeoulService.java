package com.ntels.syjeon.seoul.service;

import com.google.gson.Gson;
import com.ntels.syjeon.seoul.model.SeoulResult;
import com.ntels.syjeon.seoul.model.seoul.Row;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeoulService {


    public List<Row> getSeoulPeople(){
        String json = getApi();
        SeoulResult seoulResult = new Gson().fromJson(json, SeoulResult.class);

        return seoulResult.getOctastatapi419().getRow();
    }

    public String getApi(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);
        String url = "http://openapi.seoul.go.kr:8088/41706259786a737933326546524443/json/octastatapi419/1042/1067/";
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET,httpEntity, String.class);

        return responseEntity.getBody();
    }

    public Row findByJachigu(String jachigu){
        List<Row> rowList = getSeoulPeople();

        return rowList.stream().filter(row -> {
            return row.getJACHIGU().equals(jachigu);
        }).collect(Collectors.toList()).get(0);
    }
}
