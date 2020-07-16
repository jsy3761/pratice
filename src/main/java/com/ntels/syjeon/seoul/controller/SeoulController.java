package com.ntels.syjeon.seoul.controller;

import com.ntels.syjeon.seoul.service.SeoulService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SeoulController {
    private static final Logger logger = LoggerFactory.getLogger(SeoulController.class);

    @Autowired
    private SeoulService seoulService;

    @GetMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("rowList",seoulService.getRowsList());
        mv.setViewName("seoul");

        return mv;
    }

    @GetMapping(value = "/view")
    public ModelAndView select(@RequestParam(value = "jachigu", defaultValue = "합계") String jachigu,
                               @RequestParam(value = "gigan", defaultValue = "2020-01") String gigan){
        logger.debug(" request param : gigan : {} , jachigu : {}",gigan,jachigu);

        ModelAndView mv = new ModelAndView();
        mv.addObject("rowList",seoulService.getRowsList());
        mv.addObject("row",seoulService.getRow(gigan,jachigu));
        mv.setViewName("seoul");

        return mv;
    }

}
