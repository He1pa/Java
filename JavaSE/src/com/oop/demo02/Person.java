package com.oop.demo02;

public class Person {

    String name;
    //一个类就算什么都不屑，也会存在一个方法
    // 实例化初始值

    //无参构造
    public Person(){
        this.name = "zz";
    }

    //有参构造
    //一旦定义了有参构造，无参就必须显示定义
    public Person(String name){
        this.name = name;
    }


}
