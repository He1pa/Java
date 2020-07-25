package com.oop.demo04;

public class Student {

    private String name;
    private int id;
    private char sex;
    private int age;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
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
        if(age>120||age<0){
            this.age=3;
        }else {
            this.age = age;
        }

    }
}
