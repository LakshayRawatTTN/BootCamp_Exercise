package com.webservices.restExercise.Beans;

import javax.validation.constraints.Size;

public class Employee {

    @Size(min = 2)
    private String name;
    private int id;
    private int age;

    protected Employee() {
    }

    public Employee(String name, int age, int id) {
        this.name = name;
        this.id = id;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
