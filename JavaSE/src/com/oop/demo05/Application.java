package com.oop.demo05;

public class Application {
    public static void main(String[] args) {
        Student student = new Student();
        student.test("zzzz");
        student.test1();

        //static 结果 AB
        //非静态结果 AA
        A a = new A();
        a.test();


        //父类的引用指向子类
        //方法的调用之和左边，定义的数据类型有关
        B b = new A();
        b.test();


    }
}
