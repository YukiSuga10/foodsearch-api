package com.yuksuga.foodsearchapi.service;

import com.yuksuga.foodsearchapi.domain.User;
import com.yuksuga.foodsearchapi.domain.UserList;
import com.yuksuga.foodsearchapi.domain.UserSelector;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserList find(UserSelector selector);

    User get(Long Id);

    void add(User user);

    void set(User user);
}
