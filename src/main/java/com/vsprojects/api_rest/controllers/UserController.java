package com.vsprojects.api_rest.controllers;

import com.vsprojects.api_rest.models.User;
import com.vsprojects.api_rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<User> getUsers(){
        return this.userService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUserById(@PathVariable long id){
        return this.userService.getById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return this.userService.save(user);
    }

    @PutMapping(path = "{id}")
    public Optional<User> updateUserById(@PathVariable Long id, @RequestBody User request){
        return this.userService.update(id, request);
    }
}
