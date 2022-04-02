package com.angers.project.corejava.network;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Slf4j
public class EchoServer {

    public static void main(String [] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8091); // 创建一个服务端的套接字，监听端口 8091
            Socket income = serverSocket.accept(); // 侦听要与此套接字建立的连接，并接受它，该方法将一直阻塞直到建立连接
            InputStream inputStream = income.getInputStream(); // 使用 Socket 对象获取输入输出流
            OutputStream outputStream = income.getOutputStream();
            // 通过 Scanner 输入流
            Scanner in = new Scanner(inputStream, StandardCharsets.UTF_8.name())){
            // 通过 PrintWriter 输出流
            PrintWriter out = new PrintWriter(
                new OutputStreamWriter(
                    outputStream,StandardCharsets.UTF_8.name()),
                    true);
            out.println("Hello ! ENTER bye to exit!");
            boolean done = false;
            while (!done&&in.hasNextLine()){
                String line = in.nextLine();
                out.println("ECHO:"+line);
                if (line.trim().equals("bye")) done =true;
            }
        }
    }
}