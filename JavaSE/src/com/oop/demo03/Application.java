package com.oop.demo03;

public class Application {

    public static void main(String[] args) {
        Pet dog = new Pet();

        dog.name = "wangcai";
        dog.age = 3;
        dog.shout();

        System.out.println(dog.name);
        System.out.println(dog.age);
    }
}
