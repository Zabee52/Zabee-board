package com.sparta.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginForm(){
        return "redirect:/login-form.html";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Account ac, Model model){

        if(ac.getId().equals(ac.getPassword())){
            model.addAttribute("loginId", ac.getId());
        }
        return "login-result";
    }
}