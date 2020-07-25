package com.exception;

public class demo01 {
    public static void main(String[] args) {
        a();
    }
    public static void a(){
        b();
    }

    public static void b(){
        a();
    }
}
