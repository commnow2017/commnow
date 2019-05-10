package com.example.commnowcorepojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommnowCorePojoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommnowCorePojoApplication.class, args);
    }

}
