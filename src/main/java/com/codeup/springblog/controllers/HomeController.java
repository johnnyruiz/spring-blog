package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String landing(){
        return "This is the landing page!";
    }

    @GetMapping("/home")
    public String welcome(Model model){
        model.addAttribute("username", "Fred");
        return "home";
    }

}
