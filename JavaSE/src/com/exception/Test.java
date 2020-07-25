package com.exception;

public class Test {
    public static void main(String[] args) {

        int a = 1;
        int b = 0;

        try {

            if(b == 0){
                throw new ArithmeticException();
            }
            System.out.println(a/b);
        }catch (ArithmeticException e){
            System.out.println("出现异常");
        }finally {
            System.out.println("finnaly");
        }
    }

}
