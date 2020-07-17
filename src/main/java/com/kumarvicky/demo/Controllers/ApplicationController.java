package com.kumarvicky.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String Home()
    {
        return "index";
    }
    @GetMapping("/login")
    public String Login()
    {
        return "login";
    }
    @GetMapping("/logout")
    public String Logout()
    {
        return "login";
    }

}
