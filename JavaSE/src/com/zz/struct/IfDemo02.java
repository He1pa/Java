package com.zz.struct;

import java.util.Scanner;

public class IfDemo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();

        if(score >= 60){
            System.out.println("及格");
        }else{
            System.out.println("不及格");
        }
    }
}
