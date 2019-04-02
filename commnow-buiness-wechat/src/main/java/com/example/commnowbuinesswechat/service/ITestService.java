package com.example.commnowbuinesswechat.service;

import com.example.commnowbuinesswechat.pojo.TestPojo;

public interface ITestService {

    TestPojo selectUserByName(String name);

    void saveUser(TestPojo testPojo);
}
