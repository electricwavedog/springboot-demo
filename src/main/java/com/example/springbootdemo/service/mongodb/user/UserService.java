package com.example.springbootdemo.service.mongodb.user;

import com.example.springbootdemo.model.TUser;

/**
 * @author liuyiqian
 */
public interface UserService {

    void save(TUser user);

    void update(TUser user);

    void delete(Long id);

    TUser find(String userName);
}
