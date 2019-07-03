package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello";
    }

    @GetMapping("/goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye";
    }

    //Path Variables

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name){
        return "Howdy, " + name;
    }

    @GetMapping("/favnum/{num}")
    @ResponseBody
    public String getFavNum(@PathVariable int num){
        return "Fav num is, " + num;
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number){
        return "Number " + (number + 1);
    }
}
