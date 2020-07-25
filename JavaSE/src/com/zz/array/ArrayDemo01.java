package com.zz.array;

public class ArrayDemo01 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        int sum =0;
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        nums[4] = 4;
        nums[5] = 5;
        nums[6] = 6;
        nums[7] = 7;
        nums[8] = 8;
        nums[9] = 9;

        for (int i = 0;i < nums.length;i++){
            sum += nums[i];
        }
        System.out.println(sum);

    }
}
