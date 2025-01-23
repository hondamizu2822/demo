package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/request-scope")
public class RequestScopeController {

    @RequestMapping("")
    public String index(){
        return "request-scope-form";
        
    }

    @RequestMapping("/input-name")
    public String inputName(@RequestParam String name, Model model){
        System.out.println(name);
        model.addAttribute("name", name);
        return "result-request-scope";
        
    }
        





}
