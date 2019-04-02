package com.example.commnowbuinesswechat.controller;

import com.example.commnowbuinesswechat.pojo.TestPojo;
import com.example.commnowbuinesswechat.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    private TestPojo testPojo;

    @Autowired
    private ITestService testService;

    @Value("${server.port}")
    public String port;

    @RequestMapping("/index")
    public String index(Model model){
       model.addAttribute("port",port);
       return "index";
    }
    @RequestMapping("/test")
    public String test(String name,Model model){
        testPojo = testService.selectUserByName("1");
        model.addAttribute("testPojo",testPojo);
        return "index";
    }

    @RequestMapping("/add")
    public String add(TestPojo testPojo){
        testService.saveUser(testPojo);
        System.out.println("id1111:"+testPojo.getId());
        return "index";

    }
}
