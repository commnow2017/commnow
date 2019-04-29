package com.example.commnowserverfeign.controller;

import com.example.commnowserverfeign.server.IIndexServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    public IIndexServer indexServer;

    @RequestMapping("/")
    public String index(){
        return indexServer.getIndex();
    }

}
