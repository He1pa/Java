package com.zz.struct;

public class SwitchDemo01 {
    public static void main(String[] args) {
        char grade = 'C';

        switch (grade){
            case 'A':
                System.out.println("优秀");
                break;
            case 'B':
                System.out.println("良好");
                break;
            case 'C':
                System.out.println("中");
                break;
            case 'D':
                System.out.println("及格");
            default:
                System.out.println("未知");
        }
    }
}
