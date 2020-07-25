package com.oop.demo05;

public class Student extends Person{
    private String name = "zzz";

    public void  test(String name){
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }
    public void print(){
        System.out.println("Student");
    }

    public void test1(){
        print();
        this.print();
        super.print();

    }

    public Student() {
        //隐藏了 supper();
        System.out.println("Student无参构造");
    }
}
