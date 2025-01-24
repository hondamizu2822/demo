package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;



@Controller
@SessionAttributes("email")
public class LoginController {
    private static final String CORRECT_EMAIL = "test@example.com";
    private static final String CORRECT_PASSWORD = "123";
        
    
    @GetMapping("/login")
        public String showLoginForm() {
            return "login";
    }
    
    @PostMapping("/login")
    public String login(
        @RequestParam String email,
        @RequestParam String password,
        Model model, HttpSession session) {
                
            if (CORRECT_EMAIL.equals(email) && CORRECT_PASSWORD.equals(password)) {
             session.setAttribute("email",email);
             model.addAttribute("email", email);
             model.addAttribute("password", password);
                return "result"; 
            } else {
             model.addAttribute("error", true);
                    return "login";
            }
        }

    @GetMapping("/mypage")
    public String showMypage(
        @RequestParam String email,
        @RequestParam String password,
        Model model,HttpSession session){
            if (session.getAttribute("email") == null) {
               return "redirect:/login"; }
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            return "mypage";
        }

    

        @Override
        public String toString() {
            return "LoginController []";
        }


}
