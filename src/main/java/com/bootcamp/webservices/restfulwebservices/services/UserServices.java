package com.bootcamp.webservices.restfulwebservices.services;

import com.bootcamp.webservices.restfulwebservices.beans.User;
import org.springframework.stereotype.Component;

import javax.naming.NameNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserServices {
    static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1,"Lakshay",21,"Software Developer"));
        users.add(new User(2,"Ashish",21,"Software Engineer"));
    }
    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUserList(){
        return users;
    }
    public List<User> deleteUser(int id)  {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(id == user.getId()){
                iterator.remove();
                return users;
            }
        }
        throw new RuntimeException("User Not Found");
    }
}
