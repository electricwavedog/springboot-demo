package com.example.springbootdemo.model;

import java.io.Serializable;

/**
 * @author liuyiqian
 * @version 1.0
 * @description
 * @date 2018/3/1 下午3:01
 */
public class TTest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
