package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/post")
    @ResponseBody
    public String postIndex(){
        return "This is the post index page!";
    }

    @RequestMapping(path = "/post/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String Post(@PathVariable int id){
        return "Post " + id;
    }

    @GetMapping("/post/create")
    @ResponseBody
    public String postCreate(){
        return "This is the create post page!";
    }


    @RequestMapping(path = "/post/create/", method = RequestMethod.POST)
    @ResponseBody
    public String addOne(){
        return "This is where a post is created";
    }

}
