package com.holovin.holovin_lab1.models;

import lombok.*;

@Data
public class Person {
    int id;
    String name;
    String email;
    int age;

    public Person() {
    }

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Person(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
