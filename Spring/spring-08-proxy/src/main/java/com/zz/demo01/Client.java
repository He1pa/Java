package com.zz.demo01;

public class Client {
    public static void main(String[] args) {
        //房东要租房子
        Host host = new Host();
        //代理，中介帮房东组房子，代理一般会有一些附属操作
        Proxy proxy = new Proxy(host);
        //不用面对房东，直接找中介租房
        proxy.rent();
    }
}
