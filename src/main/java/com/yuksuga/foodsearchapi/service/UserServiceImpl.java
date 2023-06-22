package com.yuksuga.foodsearchapi.service;

import com.yuksuga.foodsearchapi.domain.User;
import com.yuksuga.foodsearchapi.domain.UserList;
import com.yuksuga.foodsearchapi.domain.UserSelector;
import com.yuksuga.foodsearchapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserList find(UserSelector selector) {
        UserList userList = new UserList();
        userList.setUsers(this.userRepository.findList(selector));
        return userList;
    }

    @Override
    public User get(Long Id) {
        return this.userRepository.findOne(Id);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void add(User user) {
        this.userRepository.insert(user);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void set(User user) {
        this.userRepository.update(user);
    }
}
