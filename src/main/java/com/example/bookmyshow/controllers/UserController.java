package com.example.bookmyshow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bookmyshow.models.User;
import com.example.bookmyshow.services.UserServices;

@RestController
public class UserController {
    
    @Autowired
    private UserServices userServices;

    @GetMapping("/users")
    private ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok().body(this.userServices.getAllUsers());
    }

    @GetMapping("/user/{userId}")
    private User getUserById(@PathVariable long userId) {
        return this.userServices.getUserById(userId);
    }

    @PostMapping("/createUser")
    private ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok().body(this.userServices.createUser(user));
    }

    @PutMapping("/updateUser/{userId}")
    private ResponseEntity<User> updateUser(@PathVariable long userId, @RequestBody User user){
        user.setUserId(userId);
        return ResponseEntity.ok().body(this.userServices.updateUser(user));
    }
    
    @DeleteMapping("/deleteUser/{userId}")
    private HttpStatus deleteUser(@PathVariable long userId){
        this.userServices.deleteUser(userId);
        return HttpStatus.OK;
    }

}
