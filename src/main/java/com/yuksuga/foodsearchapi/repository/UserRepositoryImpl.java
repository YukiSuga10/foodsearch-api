package com.yuksuga.foodsearchapi.repository;

import com.yuksuga.foodsearchapi.domain.User;
import com.yuksuga.foodsearchapi.domain.UserSelector;
import com.yuksuga.foodsearchapi.repository.mybatis.UserMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    private final SqlSession sqlSession;

    @Override
    public List<User> findList(UserSelector selector) {
        return this.sqlSession.getMapper(UserMapper.class).find(selector);
    }

    @Override
    public User findOne(Long Id) {
        User user = this.sqlSession.getMapper(UserMapper.class).get(Id);
        if (user == null){
            logger.warn("User not found. id = {}", Id);
            throw new ResourceNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public void insert(User user) {
        this.sqlSession.getMapper(UserMapper.class).add(user);
    }

    @Override
    public void update(User user) {
        this.sqlSession.getMapper(UserMapper.class).set(user);
    }

    @Override
    public void delete(User user) {

    }
}
