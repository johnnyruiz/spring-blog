package com.codeup.springblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DogsController {

//    @Autowired another way to create a dao constructor
    private DogRepository dogsDao;

    public DogsController(DogRepository dogsDao) {
        this.dogsDao = dogsDao;
    }

    @GetMapping("/dogs")
    @ResponseBody
    private Iterable<Dog> index(){
        return dogsDao.findAll();

    }
    
}
