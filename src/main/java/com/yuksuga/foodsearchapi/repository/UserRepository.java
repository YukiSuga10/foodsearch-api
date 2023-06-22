package com.yuksuga.foodsearchapi.repository;

import com.yuksuga.foodsearchapi.domain.User;
import com.yuksuga.foodsearchapi.domain.UserSelector;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;


public interface UserRepository {

    List<User> findList(UserSelector selector);

    User findOne(Long Id);

    void insert(User user);

    void update(User user);

    void delete(User user);
}
