package com.ntels.syjeon.seoul.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 공공데이터 API를 호출하여 fullJsonstring을 반환하는 서비스
 */
@Service
public class ApiService {
    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);
    private int cnt;
    private String serviceUrl = "http://openapi.seoul.go.kr:8088/41706259786a737933326546524443/json/octastatapi419/";


    public String getApi(int startIndex, int endIndex){
        cnt++;
        logger.debug("공공 API 호출 횟수 : {}", cnt);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);
        String url = new StringBuilder()
                .append(serviceUrl)
                .append(startIndex)
                .append("/")
                .append(endIndex)
                .toString();

        ResponseEntity<String> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET,httpEntity, String.class);

        return responseEntity.getBody();
    }

    public String getApi(String gigan){
        cnt++;
        logger.debug("공공 API 호출 횟수 : {}", cnt);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);
        String url = new StringBuilder()
                .append(serviceUrl)
                .append(1)
                .append("/")
                .append(26)
                .append("/")
                .append(gigan)
                .toString();

        ResponseEntity<String> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET,httpEntity, String.class);

        return responseEntity.getBody();
    }
}
