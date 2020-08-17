package com.zz.reflect;

public class Test06 {
    static {
        System.out.println("main类被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
        //Son son = new Son();
        /*
         * main类被加载
         * 父类被加载
         * 子类被加载
         * */
        //反射也会产生主动引用
        //Class.forName ("com.reflection.Son");
        /*
         * main类被加载
         * 父类被加载
         * 子类被加载
         * */
        //不会产生类的引用的方法
        //System.out.println(Son.b);
        /*
         * main类被加载
         * 父类被加载
         * 2
         * */
        //Son[] array = new Son[5];
        /*main类被加载*/
        System.out.println(Son.M) ;
        /*
         * main类被加载
         * 1
         * */
    }
}
class Father {
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }
}
class Son extends Father {
    static {
        System.out.println("子类被加载");
    }
    static int m = 100;
    static final int M = 1;
}