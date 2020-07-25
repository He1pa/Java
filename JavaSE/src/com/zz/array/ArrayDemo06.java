package com.zz.array;

import com.sun.scenario.animation.shared.ClipEnvelope;

import java.util.Arrays;

public class ArrayDemo06 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,565,324,656};
        System.out.println(a);

        System.out.println(Arrays.toString(a));
        printArray(a);

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static  void printArray(int[] a){
        for (int i = 0; i < a.length ; i++) {
            if (i==0){
                System.out.print("[" + a[i] + ", ");
            }else if (i == a.length -1){
                System.out.print(a[i]+"]\n");
            }else {
                System.out.print( a[i] + ", ");
            }

        }
    }
}
