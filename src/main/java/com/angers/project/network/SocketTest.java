package com.angers.project.network;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Slf4j
public class SocketTest {

    public static void main(String [] args) throws IOException {

        try(Socket socket = new Socket("baidu.com",80); // 创建一个 socket
            Scanner inputStream = new Scanner(socket.getInputStream(),
                    StandardCharsets.UTF_8.name())){
            socket.setSoTimeout(1000); // 设置超时时间
            while (inputStream.hasNextLine()){
                String line = inputStream.nextLine();
                log.info(line);
            }
        }
    }

}
