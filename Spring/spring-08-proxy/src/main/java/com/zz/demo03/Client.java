package com.zz.demo03;

public class Client {

    public static void main(String[] args) {
        //真实角色
        Host host = new Host();

        //代理角色，现在没有
        ProxyInvovationHandler pih = new ProxyInvovationHandler();
        pih.setRent(host);
        //这里的proxy就是动态生成的
        Rent proxy =(Rent) pih.getProxy();
        proxy.rent();

    }
}
