package com.zz.config;

import com.zz.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//这个也会被Spring容器托管，注册到容器中，因为他本就是就是一个Component
//Configuration 代表这事一个配置类，就等同于beans.xml
@Configuration
@ComponentScan("com.zz.pojo")
public class MyConfig2 {


}