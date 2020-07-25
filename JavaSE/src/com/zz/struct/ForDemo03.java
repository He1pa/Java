package com.zz.struct;

public class ForDemo03 {
    public static void main(String[] args) {
        //输出1000以内能被5整除的数，并且每行输出3个
        int j = 0;
        for (int i = 0; i < 1000; i++) {
            if((i % 5) == 0){
                System.out.print(i +" ");
                j++;
            }
            if(j == 3){
                System.out.println();
                j = 0;
            }

        }
    }
}
