package com.angers.project.network;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Slf4j
public class ThreadedEchoServerHandler implements Runnable {

    /*
    socket 对象
     */
    private final Socket income;

    /*
    最大的连接数
     */
    public static final int CONNECT_LIMIT = 100;

    /**
     * RUNNABLE 对象构造函数
     * @param incomingSocket 已建立的 socket
     * 将已建立的 socket 交给独立的线程与客户端进行通信
     * 服务端可以与不同客户端建立多个连接，相互独立运行，同时处理客户端请求
     */
    public ThreadedEchoServerHandler(Socket incomingSocket){
        income = incomingSocket;
    }

    /**
     * 使用独立的线程来接收客户端的请求与之交互
     */
    @Override
    public void run() {
        try (InputStream inputStream = income.getInputStream();
            OutputStream outputStream = income.getOutputStream();
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String [] args){

        try (ServerSocket serverSocket = new ServerSocket(8092)){
            int clientCount = 1;
            while (clientCount<CONNECT_LIMIT){
                Socket socket = serverSocket.accept();
                log.info("clientCount:"+clientCount);
                Runnable runnable = new ThreadedEchoServerHandler(socket);
                Thread thread = new Thread(runnable);
                thread.start();
                clientCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
