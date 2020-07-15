package com.ntels.syjeon.seoul.controller;

import com.ntels.syjeon.seoul.service.SeoulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SeoulController {

    @Autowired
    private SeoulService seoulService;

    @GetMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("rowList",seoulService.getJachiguList());
        mv.setViewName("seoul");
        return mv;
    }

    @GetMapping(value = "/view")
    public ModelAndView select(@RequestParam("guname") String guname){
        ModelAndView mv = new ModelAndView();
        mv.addObject("rowList",seoulService.getJachiguList());
        mv.addObject("row",seoulService.findByJachiguRecent(guname));
        mv.setViewName("seoul");
        return mv;
    }

}
