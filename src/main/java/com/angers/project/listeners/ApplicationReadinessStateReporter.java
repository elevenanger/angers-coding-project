package com.angers.project.listeners;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//监听应用状态，是否可以正常接收外部请求
@Component
@Slf4j
public class ApplicationReadinessStateReporter implements ApplicationListener<AvailabilityChangeEvent>{

    //TODO  将路径和文件名做成配置
    public final static String FILE_PATH = "/Users/liuanglin/Projects/angers-coding-project"; 

    public final static String FILE_NAME = "ApplicationReady.txt";

    private AvailabilityChangeEvent event;
    
    @EventListener
    public void onStateChanged(AvailabilityChangeEvent<ReadinessState> event){
        switch(event.getState()){
            case ACCEPTING_TRAFFIC:
            //TODO 应用状态能够正常接收请求，创建文件，为k8s提供应用就绪探针
            log.info("应用启动成功，可以正常接收请求！");
            break;
            case REFUSING_TRAFFIC:
            //TODO 应用状态无法正常接收请求，删除文件
            log.info("应用内部发生异常，无法正常接收请求！");
            break;
        }
    }

    @Override
    public void onApplicationEvent(AvailabilityChangeEvent event) {

        switch(event.getState().toString()){
            case "ACCEPTING_TRAFFIC":
            //TODO 应用状态能够正常接收请求，创建文件，为k8s提供应用就绪探针
            log.info(event.getState()+"应用启动成功，可以正常接收请求！"+event.getState().getClass()+Thread.currentThread().toString());
            break;
            case "REFUSING_TRAFFIC":
            //TODO 应用状态无法正常接收请求，删除文件
            log.info(event.getState()+"应用内部发生异常，无法正常接收请求！");
            break;
            default:
            log.info(event.getState().getClass()+Thread.currentThread().toString());
        }
    }
    
}
