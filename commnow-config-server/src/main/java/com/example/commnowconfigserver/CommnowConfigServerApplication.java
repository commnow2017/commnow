package com.example.commnowconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class CommnowConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommnowConfigServerApplication.class, args);
    }

}
