package com.example.springbootdemo.repository;


import com.example.springbootdemo.model.TUser;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author liuyiqian
 */
public interface UserRepository extends MongoRepository<TUser, String> {

    TUser findByUserName(String userName);
}
