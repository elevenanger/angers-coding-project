package com.angers.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {
    @RequestMapping("/")
        public String home() {
        return "Hello World!";
    }
    public static void main(String[] args) {
        SpringApplication applicaiton = new SpringApplication(Application.class);
        applicaiton.setApplicationStartup(new BufferingApplicationStartup(2048));
        applicaiton.run(args);
    }
}