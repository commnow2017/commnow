package com.example.commnowbuinesswechat.controller;

import com.example.commnowbuinesswechat.pojo.TestPojo;
import com.example.commnowbuinesswechat.service.ITestService;
import com.example.commnowserveractiviti.service.IActivitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
@Controller
public class TestController {
    private TestPojo testPojo;

    @Autowired
    private ITestService testService;

    @Autowired
    private IActivitiService activitiService;

    @Value("${server.port}")
    public String port;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("port", port);
        return "index";
    }

    @RequestMapping("/test")
    public String test(String name, Model model) {
        testPojo = testService.selectUserByName("1");
        model.addAttribute("testPojo", testPojo);
        return "index";
    }

    @RequestMapping("/add")
    public String add(TestPojo testPojo) {
        testService.saveUser(testPojo);
        System.out.println("id:" + testPojo.getId());
        //启动自动化流程
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", testPojo.getName());
        map.put("age", testPojo.getAge());
        System.out.println(testPojo.getAge());
        //activitiTestService = new TestServiceImpl();
        activitiService.startProcess("testProcess", map);
        return "index";

    }
}
