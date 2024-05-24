package com.sergei.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAllEmployees() {

        return "viewForAllEmployees";
    }

    @GetMapping("/hrInfo")
    public String getInfoOnlyForHR() {

        return "viewForHR";
    }

    @GetMapping("/managerInfo")
    public String getInfoOnlyForManagers(){
        return "managerView";
    }
}
