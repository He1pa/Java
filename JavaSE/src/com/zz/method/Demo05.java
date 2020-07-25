package com.zz.method;

public class Demo05 {
    public static void main(String[] args) {
        Demo05 demo05 = new Demo05();
        System.out.println(demo05.f(5) );

    }

    public static int f(int n ){
        if(n == 1)
            return 1;
        return n * f(n-1);

    }
}
