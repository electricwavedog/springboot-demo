package com.example.springbootdemo.Service;

import com.example.springbootdemo.SpringbootDemoApplicationTests;
import com.example.springbootdemo.model.TUser;
import com.example.springbootdemo.repository.UserRepository;
import com.example.springbootdemo.service.mongodb.user.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuyiqian
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(SpringbootDemoApplicationTests.class)
public class MongoTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void saveTest() {
        TUser user = new TUser();
        user.setId(1L);
        user.setUserName("aaa");
        user.setPassword("aaaa");
        userService.save(user);
    }

    @Test
    public void updateTest() {
        TUser user = new TUser();
        user.setId(1L);
        user.setUserName("bbb");
        user.setPassword("bbbb");
        userService.update(user);
    }

    @Test
    public void deleteTest() {
        userService.delete(1L);
    }

    @Test
    public void findTest() {
        TUser user = userService.find("aaa");
        Assert.assertEquals("aaaa", user.getPassword());
    }

    @Test
    public void repositoryTest() {
        userRepository.save(new TUser(2L, "ccc", "cccc"));
        TUser user = userRepository.findByUserName("ccc");
        Assert.assertEquals("ccc", user.getUserName());
        userRepository.delete(user);
        Assert.assertEquals(0, userRepository.count());
    }

}
