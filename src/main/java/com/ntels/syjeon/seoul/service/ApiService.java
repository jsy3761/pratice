package com.ntels.syjeon.seoul.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);

    @Value("${http.api.url}")
    private String serviceUrl;

    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders httpHeaders = new HttpHeaders();
    private HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);

    public String callApi(String gigan, String jachigu) {
        logger.debug("callApi param : gigan : {} , jachigu : {}", gigan, jachigu);
        String url = new StringBuilder(serviceUrl)
                .append(gigan).append("/").append(jachigu)
                .toString();

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        String jsonString = responseEntity.getBody();

        return jsonString;
    }

}
