package com.zz.method;

public class Demo01 {
    public static void main(String[] args) {
        //int sum = add(1,2);
        //System.out.println(sum);
        test();
    }

    public static int add(int a , int b){
        return a+b;
    }

    public  static void test(){
        for(int i = 1;i <= 9; i++){
            for(int j =1 ;j <=i ;j++){
                System.out.print(i + "*" + j + "=" + i * j +"\t");
            }
            System.out.println();
        }
    }
}
