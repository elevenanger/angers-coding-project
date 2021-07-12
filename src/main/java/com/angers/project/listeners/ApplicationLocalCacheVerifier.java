package com.angers.project.listeners;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//检查应用内部是否正常，适用于应用进程还在，但是应用无法继续正常工作的场景
@Component
@Slf4j
public class ApplicationLocalCacheVerifier {

    //TODO  将路径和文件名做成配置
    public final static String FILE_PATH = "/Users/liuanglin/Projects/angers-coding-project"; 

    public final static String FILE_NAME = "ApplicationLive.txt";

    private final ApplicationEventPublisher publisher;
    
    public ApplicationLocalCacheVerifier(ApplicationEventPublisher publisher){
        this.publisher = publisher;
    }

    public void checkApplicationLocalCache(){
        try {
            //创建应用存活探针
            log.info("应用启动成功，可以正常接收请求！");
        } catch (Exception e) {
            AvailabilityChangeEvent.publish(publisher, e, LivenessState.BROKEN);
        }
    }
}
