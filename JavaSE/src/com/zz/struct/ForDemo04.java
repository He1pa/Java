package com.zz.struct;

public class ForDemo04 {
    public static void main(String[] args) {
        //输出乘法口诀表
        for(int i = 1;i <= 9; i++){
            for(int j =1 ;j <=i ;j++){
                System.out.print(i + "*" + j + "=" + i * j +"\t");
            }
            System.out.println();
        }
    }
}
