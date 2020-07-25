package com.exception;

public class Test01 {
    public static void main(String[] args) {
        new Test01().test(1,0);
    }



    public void test(int a ,int b) throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException();
        }
    }
}
