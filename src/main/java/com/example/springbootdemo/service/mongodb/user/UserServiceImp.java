package com.example.springbootdemo.service.mongodb.user;

import com.example.springbootdemo.model.TUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author liuyiqian
 */
@Service
public class UserServiceImp implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(TUser user) {
        mongoTemplate.save(user);
    }

    @Override
    public void update(TUser user) {
        logger.info("======== update start ========");
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassword());
        mongoTemplate.updateFirst(query, update, TUser.class);
        logger.info("======== update end ========");
    }

    @Override
    public void delete(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, TUser.class);
    }

    @Override
    public TUser find(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        TUser user = mongoTemplate.findOne(query, TUser.class);
        return user;
    }
}
