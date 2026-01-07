package com.example.controller;

import com.example.model.User;
import com.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//TODO Write Junit Tests
//TODO Implement Controller Advice with ResponseEntityExceptionHandler
//TODO Implement logging
//TODO Implement Swagger
//TODO Create different profiles
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //TODO change return type to ResponseEntity - Done
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
           User savedUser = userService.saveUser(user);
           return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    //TODO change return type to ResponseEntity - Done
    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers(){
        Iterable<User> users = userService.getAllUsers();
        if(users.iterator().hasNext()){
            return ResponseEntity.ok(users);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    //TODO change return type to ResponseEntity - Done
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}
