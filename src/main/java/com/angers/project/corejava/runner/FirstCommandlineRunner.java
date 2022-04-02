package com.angers.project.corejava.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(value = 3)
public class FirstCommandlineRunner implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        log.info("first commandline runner");
    }
    
}
