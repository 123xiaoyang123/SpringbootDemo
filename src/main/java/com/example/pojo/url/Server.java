package com.example.pojo.url;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        //创建ServerSocket对象,用于监听Socket客户端发来的请求
        ServerSocket socket = new ServerSocket(50000);
        //采用循环来接收来自客户端的请求
        while (true) {
            Socket ss = socket.accept();
            //将Socket对象包装成printStream输出流
            PrintStream stream = new PrintStream(ss.getOutputStream());
            //普通io文本
            stream.println("你好!收到了服务器传来的消息");
            //关闭输出流
            stream.close();
            //关闭Socket
            ss.close();
        }
    }
}
