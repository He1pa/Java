package com.zz.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class ControllerTest3 {
    @RequestMapping("/test/t3")
    public String test1(Model model){
        model.addAttribute("msg","Hello3");
        return "test";

    }
}
