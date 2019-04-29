package com.example.commnowserveractiviti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@SpringBootApplication
@EnableEurekaClient
@ImportResource("classpath:spring-context.xml")
@ComponentScan
@EnableAutoConfiguration

public class CommnowServerActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommnowServerActivitiApplication.class, args);
    }

  /* @Bean
    public CommandLineRunner init(final RepositoryService repositoryService,
                                  final RuntimeService runtimeService,
                                  final TaskService taskService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                System.out.println("Number of process definitions : "
                        + repositoryService.createProcessDefinitionQuery().count());
                System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
                runtimeService.startProcessInstanceByKey("testProcess");
                System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
            }
        };

    }
    @Bean
    public DataSource database() {
        return  DataSourceBuilder.create()
                .url("jdbc:mysql://localhost/commnow-activiti?useUnicode=true&amp;characterEncoding=UTF-8")
                .username("root")
                .password("root")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }*/
}
