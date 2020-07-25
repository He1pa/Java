package com.string;

public class StringStringBufferStringBuilder {
    /**
     *  String：不可变的字符序列，底层用char[]存储
     *  StringBuffer：可变的字符序列，线程安全，效率低，底层用char[]存储
     *  StringBuilder：可变的字符序列，JDK5新增，线程不安全，效率高，底层用char[]存储
     *
     */

    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

        String str = new String();//char[] value = new char[0];
        String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};

        StringBuffer sb = new StringBuffer();//char[] value = = new char[16];
        System.out.println(sb.length());
        sb.append('a');
        sb.append('b');
        System.out.println(sb.length());
        StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length()+16]{};
        System.out.println(sb2.length());


    }
}
