package com.ntels.syjeon.seoul.controller;

import com.ntels.syjeon.seoul.service.SeoulService;
import com.ntels.syjeon.seoul.service.SeoulServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * SeoulController
 * 서울시 자치구 별 인구 표출 컨트롤러
 * @author syjeon@ntels.com
 */
@Controller
public class SeoulController {
    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SeoulController.class);

    /**
     * SeoulService
     */
    @Autowired
    private SeoulService seoulService;

    /**
     * Index Page
     * @return seoul.jsp
     */
    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("rowList", seoulService.getRowsList());
        mv.setViewName("seoul");

        return mv;
    }

    /**
     * 자치구별 인구 데이터 View
     * @param jachigu 자치구 이름
     * @param gigan 조회 기간
     * @return seoul.jsp
     */
    @GetMapping(value = "/view")
    public ModelAndView select(@RequestParam(value = "jachigu", defaultValue = "합계") String jachigu,
                               @RequestParam(value = "gigan", defaultValue = "2020-01") String gigan) {
        logger.debug(" request param : gigan : {} , jachigu : {}", gigan, jachigu);

        ModelAndView mv = new ModelAndView();
        mv.addObject("rowList", seoulService.getRowsList());
        mv.addObject("row", seoulService.getRow(gigan, jachigu));
        mv.setViewName("seoul");

        return mv;
    }

}
