package com.example.commnowutilsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommnowUtilsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommnowUtilsServerApplication.class, args);
    }

}
