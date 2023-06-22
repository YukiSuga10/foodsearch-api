package com.yuksuga.foodsearchapi.controller;

import com.yuksuga.foodsearchapi.domain.User;
import com.yuksuga.foodsearchapi.domain.UserList;
import com.yuksuga.foodsearchapi.domain.UserSelector;
import com.yuksuga.foodsearchapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("services/users")
@RequiredArgsConstructor
public class UserRestController {

    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    private final UserService userService;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserList find(UserSelector selector){
        return this.userService.find(selector);
    }

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable Long userId){
        return this.userService.get(userId);
    }
}
