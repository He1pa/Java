package com.zz.operator;

public class Demo04 {
    public static void main(String[] args) {
        // ++ -- 自增自减 一元运算符
        int a = 3;
        int b = a++;

        System.out.println(b);
        System.out.println(a);

        int c = ++a;

        System.out.println(c);
        // 幂运算
        double pow = Math.pow(2, 3);
        System.out.println(pow);


    }
}
