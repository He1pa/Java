package com.zz.base;

public class Demo08 {

    //实例变量，从属于对象 不用初始化
    String name;
    int age;
    static double salary =  2500;
    public static void main(String[] args) {
        // 局部变量，必须声明和初始化
        int i = 10;
        System.out.println(i);

        Demo08 demo08 = new Demo08();
        System.out.println(demo08.age);

        //类变量 static
        System.out.println(salary);
    }

    //其他方法
     public void add(){

     }
}
