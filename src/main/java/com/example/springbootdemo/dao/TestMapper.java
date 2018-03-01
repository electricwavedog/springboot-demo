package com.example.springbootdemo.dao;

import com.example.springbootdemo.model.TTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuyiqian
 */
@Mapper
public interface TestMapper {

//    @Select("SELECT * FROM users where id = #{id}")
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "password", column = "password")
//    })
    TTest findById(@Param("id") Long id);
}
