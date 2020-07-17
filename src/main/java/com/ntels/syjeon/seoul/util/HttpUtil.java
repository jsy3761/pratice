package com.ntels.syjeon.seoul.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Http Util
 * @author syjeon@ntels.com
 */
@Component
public class HttpUtil {
    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * Api Service Url
     */
    @Value("${http.api.url}")
    private String serviceUrl;

    /**
     * 서울시 인구 조회 공공 API Call 하여 JsonString 형태로 리턴
     * @param gigan 조회기간
     * @param jachigu 조회할 자치구
     * @return full JsonStirng
     */
    public String callApi(String gigan, String jachigu) {
        logger.debug("callApi param: gigan: {} , jachigu: {}", gigan, jachigu);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);

        String url = new StringBuilder(serviceUrl)
                .append(gigan).append("/").append(jachigu)
                .toString();

        logger.debug("ApiCall ful URL : {}",url);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        String jsonString = responseEntity.getBody();

        return jsonString;
    }

}
