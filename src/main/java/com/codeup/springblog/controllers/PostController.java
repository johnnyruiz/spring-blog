package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import com.codeup.springblog.models.Post;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/post")
    public String postIndex(Model model){
        model.addAttribute("posts", postDao.findAll());
        model.addAttribute("user", userDao.findOne(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()));
        return "post/show";
    }

    @RequestMapping(path = "post/delete/{id}")
    public String deletePost(@PathVariable Long id){
        postDao.delete(id);
        return "redirect: /post/show";
    }



    @GetMapping(path =  "/post/view/{id}")
    public String Post(@PathVariable Long id, Model model){
        model.addAttribute("post", postDao.findOne(id));
        return "post/view";
    }

    @RequestMapping(path = "/post/edit/{id}")
    public String editPost(@PathVariable Long id, Model model){
        model.addAttribute("post", postDao.findOne(id));
        return "post/edit";
    }

    @PostMapping("/post/edit/")
    private String edit(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/post";
    }

    @GetMapping("/post/create")
    private String create(Model model) {
        model.addAttribute("post", new Post());
        return "post/create";
    }

    @PostMapping("/post/create")
    private String insert(@ModelAttribute Post post){
        post.setOwner((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        postDao.save(post);
        emailService.prepareAndSend(post, "You added a post", "you did it!");
        return "redirect:/post";
    }


}
