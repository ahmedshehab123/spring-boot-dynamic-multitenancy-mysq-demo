package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.model.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;


    @PostMapping
    public User saveUser(@Valid @RequestBody User user){

        return userRepo.save(user);
    }

    @GetMapping("/{userId}")
    public User findUserById(@PathVariable("userId") Long userId){

        return userRepo.findById(userId).get();
    }

}
