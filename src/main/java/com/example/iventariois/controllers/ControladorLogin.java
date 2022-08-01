package com.example.iventariois.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorLogin {

    @RequestMapping("/login")
    public String login(Model model){
        return "views/login";
    }
}
