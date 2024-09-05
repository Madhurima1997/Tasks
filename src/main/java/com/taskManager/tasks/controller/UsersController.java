package com.taskManager.tasks.controller;

import com.taskManager.tasks.model.Users;
import com.taskManager.tasks.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    List<Users> getAllUsers(){
        log.info("In Controller");
        return userService.getAllUsers();
    }
}
