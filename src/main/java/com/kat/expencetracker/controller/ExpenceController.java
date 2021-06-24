package com.kat.expencetracker.controller;


import com.kat.expencetracker.model.Expence;
import com.kat.expencetracker.model.MyUserDetails;
import com.kat.expencetracker.model.User;
import com.kat.expencetracker.service.ExpenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ModelAndView getAllExpence(@AuthenticationPrincipal MyUserDetails myUserDetails)
    {
        User user = myUserDetails.getUser();
        ModelAndView mv = new ModelAndView("expences");
        List<Expence> expences = expenceService.getAllExpences(user);
        mv.addObject("expences", expences);
        return mv;
    }

    @GetMapping(path = "/add")
    public ModelAndView addExpence()
    {
        ModelAndView mv = new ModelAndView("add");
        Expence expence = new Expence();
        mv.addObject("expence", expence);
        return mv;
    }
    @PostMapping(path = "/add")
    public String saveExpence(@AuthenticationPrincipal MyUserDetails myUserDetails, Expence expence)
    {
        User user = myUserDetails.getUser();
        expence.setUser(user);
        expenceService.addExpence(expence);
        return "redirect:/expence";
    }
    @GetMapping(path = "/{id}/detail")
    public ModelAndView expenceDetail(@PathVariable("id") Long id)
    {
        ModelAndView mv = new ModelAndView("detail");
        Expence expence = expenceService.getExpence(id);
        mv.addObject("expence", expence);
        return mv;
    }
    @GetMapping(path = "/{id}/edit")
    public ModelAndView expenceUpdate(@PathVariable("id") Long id)
    {
        ModelAndView mv = new ModelAndView("add");
        Expence expence = expenceService.getExpence(id);
        mv.addObject("expence", expence);
        return mv;
    }
    @GetMapping(path = "/{id}/delete")
    public String expenceDelete(@PathVariable("id") Long id)
    {
        expenceService.deleteExpence(id);
        return "redirect:/expence";
    }

}
