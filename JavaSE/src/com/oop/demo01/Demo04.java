package com.oop.demo01;
//值传递  Java 都是值传递
public class Demo04 {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a);

        Demo04.chang(a);
        System.out.println(a);// 1
    }

    public  static void chang(int a){
        a = 10;
    }
}
