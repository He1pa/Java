package com.zz.operator;

public class Demo05 {
    public static void main(String[] args) {
        // 与&&或||非!
        boolean a = true;
        boolean b = false;

        System.out.println(a && b); //false
        System.out.println(a || b); //true
        System.out.println(!(a && b)); //true

        //短路运算
        System.out.println(b && a); //false

    }
}
