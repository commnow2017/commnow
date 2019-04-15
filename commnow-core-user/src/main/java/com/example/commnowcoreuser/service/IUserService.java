package com.example.commnowcoreuser.service;

import com.example.commnowcoreuser.pojo.UserPojo;
import org.springframework.stereotype.Service;

public interface IUserService {
    //新增用户
    void saveUser(UserPojo userPojo);

    //登录
    UserPojo login(String name,String password);

    //
}
