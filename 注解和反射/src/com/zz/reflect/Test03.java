package com.zz.reflect;

public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person s1 = new Student();
        System.out.println("这个人是"+s1.name);
        //方式一：通过对象获取
        Class c1 = s1.getClass();
        System.out.println(c1.hashCode());
        //方式二：通过forname获取
        Class c2 = Class.forName("com.reflection.Student");
        System.out.println(c2.hashCode());
        //通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());
        //方式四：基本内置类型的包装类都有一个TYPE属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);
        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}
class Person{
    public String name;
    public Person(){}
    public Person(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student extends Person{
    public Student(){
        this.name = "Student";
    }
}
class Teacher extends Person{
    public Teacher(){
        this.name = "Teacher";
    }
}