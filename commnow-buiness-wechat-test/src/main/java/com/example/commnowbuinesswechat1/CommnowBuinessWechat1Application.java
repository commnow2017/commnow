package com.example.commnowbuinesswechat1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommnowBuinessWechat1Application {

    public static void main(String[] args) {
        SpringApplication.run(CommnowBuinessWechat1Application.class, args);
    }

}
