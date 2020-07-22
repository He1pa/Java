package com.zz.struct;

public class ForDemo02 {
    public static void main(String[] args) {
        //计算100 奇数和偶数的和
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < 100; i++) {
            if((i & 1) == 1){
                oddSum += i;
            }else {
                evenSum += i;
            }

        }
        System.out.println("oddSum:"+oddSum);
        System.out.println("evenSum:"+evenSum);
    }
}
