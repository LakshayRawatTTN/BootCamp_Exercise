package com.bootcamp.webservices.restfulwebservices.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class HelloWorldController {


    @Autowired
    private MessageSource messageSource;


    //Internationalized Get Method
    @GetMapping(path = "/Hello-World/{name}")
    public String helloWorld(@PathVariable("name") String name){
        return messageSource.getMessage("hello.message",null, LocaleContextHolder.getLocale())+" "+name;
    }

//    @GetMapping("/hello-world-internationalized")
//    public String helloWorld()
//    {
//        return messageSource.getMessage("hello.world.message",null, LocaleContextHolder.getLocale());
//    }



}
