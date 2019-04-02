package com.example.commnowbuinesswechat1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Value("${server.port}")
    public String port;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("port",port);
        return "index";
    }

}
