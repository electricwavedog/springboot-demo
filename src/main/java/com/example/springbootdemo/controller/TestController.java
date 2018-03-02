package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.TTest;
import com.example.springbootdemo.service.cache.CacheService;
import com.example.springbootdemo.service.user.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author liuyiqian
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @Autowired
    private CacheService cacheService;

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

    @GetMapping("{id}")
    public ModelAndView find(@PathVariable("id") Long id, ModelAndView modelAndView) {
        TTest test = testService.findById(id);
        modelAndView.addObject("test", test);
        modelAndView.setViewName("testPage");
        logger.info("=============================================");
        return modelAndView;
    }

    @RequestMapping("/redis_test")
    public ModelAndView redisTest(ModelAndView modelAndView) {
        TTest tTest = testService.findById(1L);
        cacheService.saveObject(tTest.getId(), tTest);
        modelAndView.addObject("test", cacheService.getObject(tTest.getId()));
        modelAndView.setViewName("testPage");
        return modelAndView;
    }
}
