package com.bootcamp.exercise.employee.entities;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empid")
    private long id;
    @Column(name = "empfirstname")
    private String firstName;
    @Column(name = "emplastname")
    private String lastName;
    @Column(name = "empsalary")
    private int Salary;
    @Column(name = "empage")
    private int age;

    @Embedded
    private Salary salary;

    public void setSalary(com.bootcamp.exercise.employee.entities.Salary salary) {
        this.salary = salary;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
