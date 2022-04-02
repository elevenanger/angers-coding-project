package com.angers.project.corejava.network;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

@Slf4j
public class InetAddressTest {

    public static void main (String [] args) throws UnknownHostException {
        // 解析域名ip地址
        InetAddress address = InetAddress.getByName("www.baidu.com");
        log.info(address.toString());
        // 通过系统配置的 name service 查找全部的 ip 地址
        InetAddress [] addresses = InetAddress.getAllByName("www.github.com");
        Arrays.stream(addresses).iterator().forEachRemaining(v -> log.info(v.toString()));
        // 本机地址
        InetAddress localHostAddress = InetAddress.getLocalHost();
        log.info(localHostAddress.toString());
    }
}
