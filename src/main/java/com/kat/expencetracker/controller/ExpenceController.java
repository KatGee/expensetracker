package com.kat.expencetracker.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/expence")
public class ExpenceController {

    @GetMapping
    public ModelAndView getAllExpence()
    {
        ModelAndView mv = new ModelAndView("expences");

        return mv;
    }
}
