package com.example.test.service.user;

import com.example.test.dao.UserMapper;
import com.example.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyiqian
 */
@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
