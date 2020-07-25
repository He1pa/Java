package com.oop.demo01;

public class Demo02 {
    public static void main(String[] args) {

        //静态
        Student.eat();

        //非静态
        Student student = new Student();
        student.say();
    }
}
