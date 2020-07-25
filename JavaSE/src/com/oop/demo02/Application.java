package com.oop.demo02;

import com.oop.demo02.Person;


public class Application {
    public static void main(String[] args) {
        Person person = new Person();

        System.out.println(person.name);

        Person person1 = new Person("zzzz");
        System.out.println(person1.name);
    }
}
