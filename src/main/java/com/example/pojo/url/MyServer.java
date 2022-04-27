package com.example.pojo.url;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyServer {
    //定义保存所有Socket的ArrayList,并将其包装成线程安全的
    public static List<Socket> socketList= Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws Exception{
        ServerSocket ss=new ServerSocket(20000);

        while (true){
            //此行代码会阻塞,将一直等待客户端的连接
            Socket socket=ss.accept();
            socketList.add(socket);
            //每当客户端连接后一个ServerThread线程为该客户端服务
            new Thread(new ServerThread(socket)).start();
        }
    }

}
