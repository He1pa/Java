package com.zz.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//等价于<bean id = "user" class= "com.zz.pojo.User">
//组件
@Component
public class User {

    public String name ;
    @Value("zz")
    public void setName(String name) {
        this.name = name;
    }
}
