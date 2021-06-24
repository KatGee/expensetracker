package com.kat.expencetracker.controller;

import com.kat.expencetracker.model.UserRegistration;
import com.kat.expencetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/register")
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping
    public ModelAndView register()
    {
        ModelAndView mv = new ModelAndView("signup");
        UserRegistration userRegistration = new UserRegistration();
        mv.addObject("userRegistration", userRegistration);
        return mv;
    }
    @PostMapping(path = "/signup")
    public String signup(UserRegistration userRegistration)
    {
        userService.save(userRegistration);
        return "signupsuccess";
    }

}
