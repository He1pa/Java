package com.zz.annotation;

public class Test01 extends Object{
    @Override
    public String toString() {
        return super.toString();
    }

    //Deprecated
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }
    @SuppressWarnings({"all"})
    public void test01(){

    }

    public static void main(String[] args) {
            test();
    }
}
