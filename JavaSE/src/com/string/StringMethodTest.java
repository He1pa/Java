package com.string;

public class StringMethodTest {
    public static void main(String[] args) {
        String s1 = "   Hello World   ";
        //字符串长度
        System.out.println(s1.length());
        //返回指定位置的字符
        System.out.println(s1.charAt(7));
        //判断当前数组是否是空的
        System.out.println(s1.isEmpty());
        //转换成大/小写；
        String s2 = s1.toLowerCase();
        String s3 = s1.toUpperCase();
        //s1 不变
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        //去掉首尾的空格
        String s4 = s1.trim();
        System.out.println(s4);
        //比较字符串是否相同
        System.out.println(s1.equals(s2));
        //忽略大小写是否相同
        System.out.println(s1.equalsIgnoreCase(s2));
        //拼接，等同于+
        System.out.println(s1.concat(s2));
        //比较大小
        String s5 = "abc";
        String s6 = "abd";
        System.out.println(s5.compareTo(s6));
        //取子串
        System.out.println(s1.substring(5));
        System.out.println(s1.substring(5,9));//左闭右开 5-8
        //endwith  startswith
        System.out.println(s4.endsWith("ld"));
        System.out.println(s4.startsWith("He"));

        //包含子串
        System.out.println(s1.contains("or"));
        //字串的索引位置
        System.out.println(s1.indexOf("or"));//不存在返回-1
        //替换字符、字符串
        System.out.println(s1.replace('H','R'));
        System.out.println(s1.replace("He","RT"));



    }


}


