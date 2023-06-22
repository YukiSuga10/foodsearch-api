package com.yuksuga.foodsearchapi.repository.mybatis;

import com.yuksuga.foodsearchapi.domain.User;
import com.yuksuga.foodsearchapi.domain.UserSelector;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    List<User> find(UserSelector selector);
    User get(@Param("userId") Long userId);
    int add(User user);

    int set(User user);
}
