package com.taskManager.tasks.controller;

import com.taskManager.tasks.model.Users;
import com.taskManager.tasks.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/allUsers")
    public List<Users> getAllUsers(){
        log.info("In Controller");
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    @ResponseStatus(code= HttpStatus.CREATED)
    public void registerUser(@RequestBody Users user) {
        userService.registerUser(user);
    }
}
