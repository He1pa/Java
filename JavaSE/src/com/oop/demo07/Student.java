package com.oop.demo07;

public class Student {

    private static int age;//静态变量 多线程
    private double score;//非静态常量

    public static void main(String[] args) {
        Student s1  = new Student();

        System.out.println(Student.age);
        //System.out.println(Student.double);
        System.out.println(s1.age);
        System.out.println(s1.score);


        go();
        //run();
        s1.run();

    }

    public void run(){
        go();
    }

    public static void go(){

    }
}
