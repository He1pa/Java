package com.zz.base;

public class Demo06 {
    public static void main(String[] args) {
        //操作比较大的数的时候，注意溢出问题
        int money = 1_000_000_000;//JDK7新特性，数字可以用下划线分割
        int year = 20;
        int total = money * year;
        System.out.println(total);

        long total2 = money * year;

        long total3 = money * ((long)year);
        System.out.println(total3);
    }
}
