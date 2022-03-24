package com.bootcamp.webservices.restfulwebservices;

import org.springframework.stereotype.Component;


public class HelloWorldBeans {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public HelloWorldBeans(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "HelloWorldBeans{" +
                "message='" + message + '\'' +
                '}';
    }
}
