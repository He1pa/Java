package com.zz.method;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        double n1,n2;
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("是否计算 Y/N");
            String flag = scanner.next();
            if(flag.equals("N"))
                break;
            System.out.println("请输入第一个数");
            double v = scanner.nextDouble();
            System.out.println("请输入第二个数");
            double v1 = scanner.nextDouble();
            System.out.println("请输入运算符");
            String op = scanner.next();

            switch (op){
                case "+" :
                    System.out.println(v + "+" + v1 + "=" + add(v,v1));
                    break;
                case "-" :
                    System.out.println(v + "-" + v1 + "=" + sub(v,v1));
                    break;
                case "*" :
                    System.out.println(v + "*" + v1 + "=" + mul(v,v1));
                    break;
                case "/" :
                    System.out.println(v + "/" + v1 + "=" + div(v,v1));
                    break;
                default:
                    System.out.println("错误的运算符");
            }



        }

        scanner.close();



    }
     public static double add(double n1,double n2){
        return n1+n2;
     }
     public static double sub(double n1,double n2){
        return n1-n2;
     }
     public static double mul(double n1,double n2){
        return n1*n2;
     }
     public static double div(double n1,double n2){
        return n1/n2;
     }
}
