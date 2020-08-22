package com.zz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zz.pojo.User;
import com.zz.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller会走视图解析器  @ResponseBody配合@Controller使用则不会走视图解析器 返回字符串
//@RestController 直接返回字符串，不走视图解析器
@RestController
public class UserController {

    @RequestMapping("/j1")
    //@ResponseBody //不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        //jackson  ObjectionMapper
        ObjectMapper mapper = new ObjectMapper();

        User user = new User("zz",3,"男");
        String s = mapper.writeValueAsString(user);
        return s;
    }

    @RequestMapping("/j2")
    //@ResponseBody //不会走视图解析器，会直接返回一个字符串
    public String json2() throws JsonProcessingException {

        //jackson  ObjectionMapper
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = new ArrayList<User>();
        User user1 = new User("zz1",3,"男");
        User user2 = new User("zz1",3,"男");
        User user3 = new User("zz2",3,"男");
        User user4 = new User("zz3",3,"男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        String s = mapper.writeValueAsString(userList);
        return s;
    }

    @RequestMapping("/j3")
    //@ResponseBody //不会走视图解析器，会直接返回一个字符串
    public String json3() throws JsonProcessingException {

        //jackson  ObjectionMapper

        Date date = new Date();

        return new ObjectMapper().writeValueAsString(date);
    }

    @RequestMapping("/j4")
    public String json4() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);

        Date date = new Date();
        String str = mapper.writeValueAsString(date);

        return str;
    }

    @RequestMapping("/j5")
    public String json5() throws JsonProcessingException {
        Date date = new Date();
        String json = JsonUtils.getJson(date);
        return json;
    }

}
