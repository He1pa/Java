package com.oop.demo10;

public class Outer {

    private int id;
    public void out(){
        System.out.println("out");
    }
    //  内部类
    public class Inner{
        public  void in(){
            System.out.println("in");
        }
    }

    //  内部类获得外部类的私有属性
    public void getId(){
        System.out.println(id);
    }
}
