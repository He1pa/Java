package com.zz.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test03 {
    //注解可以显示赋值，如果没有默认值 ，我们就必须给注解赋值
    @MyAnnotation2(name = "zz",age = 12)
    public void test(){}
    @MyAnnotation3("zz")//参数只有一个，且参数名为value
    public void test1(){}




    @Target({ElementType.TYPE,ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnnotation2{
        //注解的参数:参数类型+参数名();
        String name() default "";
        int age() default 0;
        int id() default -1;// 如果默认值为-1,代表不存在。
        String[] schools() default {"清华大学，北大"};
    }

    @Target({ElementType.TYPE,ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnnotation3{
        //只有一个参数时，参数名为value时，使用时不需参数名
        String value();
    }
}

