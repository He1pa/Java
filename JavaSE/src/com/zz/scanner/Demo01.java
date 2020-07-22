package com.zz.scanner;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("使用next方式接受");
        if(scanner.hasNext()){
            String str = scanner.next();
            System.out.println("输出的内容为："+str);
        }
        //IO流的类如果不关闭会一直占用资源
        scanner.close();
    }
}
