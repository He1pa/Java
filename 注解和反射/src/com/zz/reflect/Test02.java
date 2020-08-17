package com.zz.reflect;

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*通过反射获取类的Class对象，
         *一个类只有一个Class对象，所以c1，c2，c3的hashcode相同
         *一个类被加载后，整个类的结构都会被封装在Class对象中
         */
        Class c1 = Class.forName("com.reflection.User");

        System.out.println(c1.getName());//com.reflection.User
        Class c2 = Class.forName("com.reflection.User");
        System.out.println(c2.hashCode());
        Class c3 = Class.forName("com.reflection.User");
        System.out.println(c3.hashCode());
    }


}

// 实体类：pojo，entity，只有属性
class User{
    private String name;
    private int id;
    private  int age;

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}