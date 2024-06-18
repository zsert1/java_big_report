package com.bigboard.boardserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigboard.boardserver.service.impl.UserServiceImpl;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {


    private final UserServiceImpl userService;
    
    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService=userService;
    }

}
