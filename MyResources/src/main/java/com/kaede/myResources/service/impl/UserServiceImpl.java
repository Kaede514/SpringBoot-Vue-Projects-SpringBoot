package com.kaede.myResources.service.impl;

import com.kaede.myResources.mapper.UserMapper;
import com.kaede.myResources.pojo.User;
import com.kaede.myResources.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kaede
 * @create 2022-08-14 17:46
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }


    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
