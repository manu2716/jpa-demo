package com.example.controller;

import com.example.model.User;
import com.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//TODO Implement Controller Advice with ResponseEntityExceptionHandler
//TODO Implement logging
//TODO Implement Swagger
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //TODO change return type to ResponseEntity
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    //TODO change return type to ResponseEntity
    @GetMapping
    public Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //TODO change return type to ResponseEntity
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}
