package com.zz.scanner;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        //输入多个数字，并求总和和平均数，每个数字回车确认，非数字表示输入结束

        Scanner scanner = new Scanner(System.in);

        double sum = 0;

        int m = 0;
        while(scanner.hasNextDouble()){
            double x = scanner.nextDouble();
            m ++;
            sum += x;
        }

        scanner.close();

        System.out.println(m + "个数字的和：" + sum+",平均数为"+(sum/m));

    }
}
