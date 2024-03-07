package com.gfg.springwebfluxtestingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SpringWebfluxTestingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxTestingDemoApplication.class, args);
    }

}
