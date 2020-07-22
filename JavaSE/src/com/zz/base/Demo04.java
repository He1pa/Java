package com.zz.base;

public class Demo04 {
    public static void main(String[] args) {
        //整数扩展 二进制0b 十进制 八进制0 十六进制0x

        int i = 10;
        int i2 = 010;//八进制
        int i3 = 0x10;//十六进制
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);


        //浮点数扩展
        //float 带有舍入误差 大约表示 接近但不等于
        //
        //最好完全避免使用浮点数进行比较
        //
        //BigDecimal 类
        float f = 01f;
        double d = 1.0/10;
        System.out.println(f == d);

        float d1 = 231213231232313f;
        float d2 = d1 + 1;
        System.out.println(d1 == d2);

        //字符扩展
        // 所有字符的本质还是数字
        char c1 = 'a';
        char c2 = '中';
        char c3= '\u0061';
        System.out.println(c1);
        System.out.println((int)c1);//强制转换
        System.out.println(c2);
        System.out.println((int)c2);
        System.out.println(c3);

        //转义字符
        // \n \t

    }
}
