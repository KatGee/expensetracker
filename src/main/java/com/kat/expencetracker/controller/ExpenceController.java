package com.kat.expencetracker.controller;


import com.kat.expencetracker.model.Expence;
import com.kat.expencetracker.service.ExpenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/expence")
public class ExpenceController {

    @Autowired
    ExpenceService expenceService;

    @GetMapping
    public ModelAndView getAllExpence()
    {
        ModelAndView mv = new ModelAndView("expences");

        return mv;
    }

    @GetMapping(path = "/add")
    public ModelAndView addExpence()
    {
        ModelAndView mv = new ModelAndView("add");
        Expence expence = new Expence();
        expence.setProductName("Laptop");
        expence.setProductDescription("It is a Dell Laptop");
        mv.addObject("expence", expence);
        return mv;
    }
    @PostMapping(path = "/add")
    public String saveExpence(Expence expence)
    {
        expenceService.addExpence(expence);
        return "redirect:/expence";
    }
}
