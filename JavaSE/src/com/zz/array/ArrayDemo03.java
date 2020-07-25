package com.zz.array;

public class ArrayDemo03 {
    public static void main(String[] args) {
        int[] arrays = {1,2,3,4,5};
        int sum = 0;
        int max = arrays[0];
        for(int i =0;i < arrays.length ; i++){
            System.out.println(arrays[i]);
            sum += arrays[i];
            if(arrays[i]>max)
                max = arrays[i];
        }

        System.out.println(sum);
        System.out.println(max);

        //for each 循环
        for(int a: arrays){
            System.out.println(a);
        }
        printArray(arrays);
        reversearray(arrays);
        printArray(arrays);

    }
    //打印数组
    public static  void printArray(int[] arrays){
        for(int a: arrays){
            System.out.println(a);
        }
    }

    //反转数组
    public static int[] reversearray(int[] arrays){
        int temp;
        for (int i = 0; i < arrays.length / 2 ; i++) {
            temp = arrays[i];
            arrays[i] = arrays[arrays.length - 1 - i];
            arrays[arrays.length - 1 - i] = temp;
        }
        return arrays;

    }
}
