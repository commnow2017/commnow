package com.example.commnowbuinesswechat.serviceImpl;

import com.example.commnowbuinesswechat.dao.TestDao;
import com.example.commnowbuinesswechat.pojo.TestPojo;
import com.example.commnowbuinesswechat.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@SuppressWarnings("ALL")
@Service
@Transactional
public class ITestServiceImpl implements ITestService {

    @Autowired
    private TestDao testDao;

    @Override
    public TestPojo selectUserByName(String name) {
        return testDao.selectUserByName(name);
    }

    @Override
    public void saveUser(TestPojo testPojo) {
        testDao.saveUser(testPojo);
    }
}
