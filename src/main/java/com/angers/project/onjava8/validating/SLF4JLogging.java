package com.angers.project.onjava8.validating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : liuanglin
 * @date : 2022/4/27 15:31
 * @description :校验-日志
 */
public class SLF4JLogging {
    /*
    slf4j 是一个 java 的日志门面
    允许终端用户在部署的时候插入需要的日志框架
    输入的日志格式取决于连接到 slf4j 的后端日志框架包
     */
    private static Logger logger = LoggerFactory.getLogger(SLF4JLogging.class);

    public static void main(String[] args) {
        logger.info("hello logger");
        // slf4j 的日志级别
        logger.trace("hello");
        logger.debug("darkness");
        logger.info("my");
        logger.warn("old");
        logger.error("friend");
    }
}
