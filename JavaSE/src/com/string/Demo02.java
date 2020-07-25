package com.string;
//String不可变性
public class Demo02 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";

        System.out.println(s1 == s2);//true

        s1 = "helllo";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);//false

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);
        System.out.println(s2 == s3);//false

        String s4 = "abc";
        String s5 = s4.replace("a","m");
        System.out.println(s4);
        System.out.println(s5);
    }
}
