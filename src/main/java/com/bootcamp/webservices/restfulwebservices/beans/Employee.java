package com.bootcamp.webservices.restfulwebservices.beans;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
//for dynamic filtering
@JsonFilter("EmployeeFilter")
public class Employee {

    int id;
    String name;
    //for static filtering
    @JsonIgnore
    String password;

    public Employee(){

    }
    public Employee(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
