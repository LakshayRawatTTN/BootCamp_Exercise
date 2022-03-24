package com.bootcamp.webservices.restfulwebservices.controller;

import com.bootcamp.webservices.restfulwebservices.beans.User;
import com.bootcamp.webservices.restfulwebservices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServices service;

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user){
        service.addUser(user);
        return user;
    }

    @GetMapping("/user-list")
    public List<User> getList(){
        return service.getUserList();
    }

    @DeleteMapping("/delete-user/{id}")
    public List<User> deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }

}
