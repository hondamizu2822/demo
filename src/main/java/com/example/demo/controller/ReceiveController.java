package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/receive")
public class ReceiveController {

    @RequestMapping("")
    public String index(){
        return "info-form";

    }

    @RequestMapping("/receive-info")
     public String receiveInfo(@RequestParam String name, String model){
        System.out.println("入力された名前は" + name + "です");
        System.out.println("入力された年齢は" + model + "です");
        return "finished";

        
    }
    
}
