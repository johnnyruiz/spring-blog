package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{a}/and/{b}")
    @ResponseBody
    public static String add(@PathVariable int a,@PathVariable int b){
       return "The sum of " + a + " and " + b + " is: " + (a + b);
    }
    @GetMapping("/subtract/{a}/and/{b}")
    @ResponseBody
    public static String subtract(@PathVariable int a,@PathVariable int b){
       return "The difference of  " + a + " and " + b + " is: " + (a - b);
    }
    @GetMapping("/multiply/{a}/and/{b}")
    @ResponseBody
    public static String multiply(@PathVariable int a,@PathVariable int b){
       return "The Product of  " + a + " and " + b + " is: " + (a * b);
    }
    @GetMapping("/divide/{a}/and/{b}")
    @ResponseBody
    public static String divide(@PathVariable int a,@PathVariable int b){
       return "The Quotient of " + a + " and " + b + " is: " + (a / b);
    }

}
