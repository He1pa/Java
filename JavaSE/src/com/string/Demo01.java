package com.string;

public class Demo01 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s3 = "hello";
        String s2 = "world";

        System.out.println(s1 == s3);//true

        String s4 = new String("hello");
        String s5 = new String("hello");
        System.out.println(s4 == s5);//false
        System.out.println(s4.equals(s5));//true

        char[] c = {'s','u','n','j','a','v','a'};
        String s6 = new String(c);
        String s7 = new String(c, 4, 4);
        System.out.println(s6);//sun java
        System.out.println(s7);//java

    }
}
