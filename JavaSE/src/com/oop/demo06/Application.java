package com.oop.demo06;

public class Application {
    public static void main(String[] args) {

        //student能使用自己或父类的方法
        Student student0 = new Student();
        //父类可以指向子类，但不能调用子类独有的方法 eat
        Person student1 = new Student();
        Object student2 = new Student();

        student0.run();
        student1.run();
        //student1.eat();


        System.out.println(student0 instanceof Student);
        System.out.println(student0 instanceof Person);
        System.out.println(student0 instanceof Object);

        //高转低 使用强制转换
        Student student21 = (Student) student2;
        student21.eat();
        //低转高会丢失子类方法
        Person student01 = student0;
        //student01.eat();

    }
}
