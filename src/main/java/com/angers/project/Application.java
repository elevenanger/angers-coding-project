package com.angers.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.angers.project.dao")
public class Application {

    @RequestMapping("/")
        public String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
    }
}