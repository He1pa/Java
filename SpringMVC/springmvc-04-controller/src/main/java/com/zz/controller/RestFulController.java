package com.zz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {
    @RequestMapping(value="/add/{a}/{b}",method = RequestMethod.GET)
    public String test1(@PathVariable int a, @PathVariable int b, Model model){
        model.addAttribute("msg",a+b);
        return "test";
    }

    @PostMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model){
        model.addAttribute("msg",a+b);
        return "test";
    }
}
