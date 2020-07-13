package com.ntels.syjeon.seoul.controller;

import com.ntels.syjeon.seoul.model.seoul.Row;
import com.ntels.syjeon.seoul.service.SeoulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SeoulController {

    @Autowired
    private SeoulService seoulService;

    @GetMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("rowList",seoulService.getSeoulPeople());
        mv.setViewName("index");
        return mv;
    }

    @GetMapping(value = "/view")
    public ModelAndView select(@RequestParam("guname") String guname){
        ModelAndView mv = new ModelAndView();
        mv.addObject("rowList",seoulService.getSeoulPeople());
        mv.addObject("row",seoulService.findByJachigu(guname));
        mv.setViewName("index");
        return mv;
    }

    @GetMapping(value = "/getRows")
    @ResponseBody
    public List<Row> getRows(){
        return seoulService.getSeoulPeople();
    }

}
