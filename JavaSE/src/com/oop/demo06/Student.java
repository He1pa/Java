package com.oop.demo06;

public class Student extends Person{
    @Override
    public void run() {
        System.out.println("student run");
    }

    public void eat(){
        System.out.println("eat");
    }
}
