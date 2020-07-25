package com.oop.demo05;

public class Person {
    protected String name = "zz";
    //改成private 则私有的无法被子类访问
    public void print(){
        System.out.println("Person");
    }

    public Person() {
        System.out.println("Person无参构造");
    }
}
