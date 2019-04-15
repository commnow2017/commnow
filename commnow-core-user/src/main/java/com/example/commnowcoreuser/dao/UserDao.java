package com.example.commnowcoreuser.dao;

import com.example.commnowcoreuser.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    //新增用户
    void saveUser(UserPojo userPojo);

    //查询单个用户 可用于登录
    UserPojo getUser(String columnName,String columnValue);

}
