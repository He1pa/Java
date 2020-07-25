package com.zz.array;

import java.util.Arrays;

public class ArrayDemo07 {
    public static void main(String[] args) {
        int[] a = {1,2,3,543,3634,34};
        int[] sort = sort(a);
        System.out.println(Arrays.toString(sort));
    }

    //冒泡排序

    public static int[] sort(int[] array){
        for (int i = 0; i < array.length - 1 ; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j+1] < array[j]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;

    }
}
