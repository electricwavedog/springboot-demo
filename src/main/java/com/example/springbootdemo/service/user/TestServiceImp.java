package com.example.springbootdemo.service.user;

import com.example.springbootdemo.dao.TestMapper;
import com.example.springbootdemo.model.TTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyiqian
 */
@Service
public class TestServiceImp implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public TTest findById(Long id) {
        return testMapper.findById(id);
    }
}
