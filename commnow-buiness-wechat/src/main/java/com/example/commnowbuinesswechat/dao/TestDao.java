package com.example.commnowbuinesswechat.dao;

import com.example.commnowbuinesswechat.pojo.TestPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDao {
    //查询单个用户
    TestPojo selectUserByName(String name);

    //新增用户
    void saveUser(TestPojo test);
}
