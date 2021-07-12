package com.angers.project.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(value = 4)
public class SecondCommandLineRunner implements CommandLineRunner{
    
    @Override
    public void run(String... args) throws Exception {
        log.info("second commandline runner");
    }
    
}
