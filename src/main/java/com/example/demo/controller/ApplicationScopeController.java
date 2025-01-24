package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/application-scope")
public class ApplicationScopeController {

    @Autowired
    private ServletContext application;


    @RequestMapping("/home")
    public String index() {
           Integer counter = (Integer) application.getAttribute("counter");
           if (counter == null){
            application.setAttribute("counter", 1);
           } else{
            counter ++;
            application.setAttribute("counter", counter);
           }

           //application.setAttribute("counter", 10);
           return "application-scope";

    }
}
