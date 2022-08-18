package com.company;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 2; //
    public transient String name; // transient делает поле несериализуемым
    private int age;
    public int sex2;


    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person {" +
                "name = '" + name + '\'' +
                ", age = " + age +
                '}';
    }
}
