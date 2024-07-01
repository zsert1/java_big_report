package com.bigboard.boardserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigboard.boardserver.service.impl.PostServiceImpl;
import com.bigboard.boardserver.service.impl.UserServiceImpl;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/posts")
@Log4j2
public class PostController {

    private final PostServiceImpl postService;
    private final UserServiceImpl userService;

    public PostController(PostServiceImpl postService, UserServiceImpl userService) {
        this.postService = postService;
        this.userService = userService;
    }

}
