package com.zz.config;

import com.zz.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//这个也会被Spring容器托管，注册到容器中，因为他本就是就是一个Component
//Configuration 代表这事一个配置类，就等同于beans.xml
@Configuration
@ComponentScan("com.zz.pojo")
@Import(MyConfig2.class)
public class MyConfig {


    //注册一个bean 就相当于之前写的一个bean标签
    //这个方法的名字相当于 id
    // 返回值 相当于class属性
    @Bean
    public User getUser(){
        return new User();
    }
}