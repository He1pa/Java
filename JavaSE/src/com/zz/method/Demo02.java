package com.zz.method;

public class Demo02 {
    public static void main(String[] args) {
    int max= max(10,20);
        System.out.println(max);
    }
    public static int max(int num1,int num2){
        int result;

        if(num1>num2){
            result = num1;
        }else {
            result =num2;
        }
        return result;
    }
}
