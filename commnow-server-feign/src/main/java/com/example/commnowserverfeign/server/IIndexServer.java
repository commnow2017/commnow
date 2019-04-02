package com.example.commnowserverfeign.server;

import com.example.commnowserverfeign.server.impl.IndexServer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "commnow-buiness-wechat", fallback = IndexServer.class)
public interface IIndexServer {

    @RequestMapping("/index")
    String getIndex();
}
