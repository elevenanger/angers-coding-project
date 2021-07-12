package com.angers.project.listeners;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent>{

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        log.info("开始启动监听"+Thread.currentThread().toString()+"ApplicationStartingEvent");  
    }
    
}
