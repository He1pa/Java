package com.zz.controller;

import com.zz.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    public String test(@RequestParam("username") String name, Model model){
        //1 接收参数
        System.out.println("接收到前端的数据name："+name);
        //2返回给前端
        model.addAttribute("msg",name);
        //3 跳转视图
        return "test";
    }

    @GetMapping("/t2")
    public String test2(User user, Model model){
        //1 接收参数
        System.out.println(user);
        //2返回给前端

        //3 跳转视图
        return "test";
    }

    @GetMapping("/t3")
    public String test3(@RequestParam("username") String name, ModelMap model){
        //封装要显示到视图中的数据
        //相当于req.setAttribute("name",name);
        model.addAttribute("msg",name);
        System.out.println(name);
        return "test";
    }
}
