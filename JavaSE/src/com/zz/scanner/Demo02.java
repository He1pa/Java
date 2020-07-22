package com.zz.scanner;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用nextline方式接受：");

        if(scanner.hasNextLine()){
            String s = scanner.nextLine();
            System.out.println("输出的内容为："+ s);
        }

        scanner.close();
    }
}
