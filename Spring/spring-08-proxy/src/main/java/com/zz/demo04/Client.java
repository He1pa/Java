package com.zz.demo04;

import com.zz.demo02.UserService;
import com.zz.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();
        //代理角色
        ProxyInvovationHandler pih = new ProxyInvovationHandler();
        //设置要代理的对象
        pih.setTarget(userService);
        //动态获得代理类
        UserService proxy = (UserService) pih.getProxy();
        proxy.add();
    }
}
