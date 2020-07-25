package com.string;

import sun.security.mscapi.CPublicKey;

public class Demo03 {

    String str = new String("good");
    char[] ch = {'t','e','s','t'};
    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        demo03.change(demo03.str,demo03.ch);

        System.out.println(demo03.str);//good
        System.out.println(demo03.ch);//test


    }

    public void change(String str,char[] ch){
        str = "test ok";
        ch[0] = 'b';
    }
}
