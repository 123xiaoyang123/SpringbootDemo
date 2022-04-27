package com.example.pojo.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/*
 * 负责处理每个线程通线的处理类
 *
 * */
public class ServerThread implements Runnable {
    //定义当前线程处理的Socket
    Socket socket = null;
    //该线程所处理的Socket对应的输入流
    BufferedReader bufferedReader;

    public ServerThread(Socket soc) throws Exception {
        this.socket = soc;
        //初始化该Socket对应的输入流
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {

        try {
            String content = null;
            //采用循环方式不断从Socket中读取客户端发过来的数据
            while ((content = readFromClient()) != null) {
                //遍历每个Socket,将数据发送给socketList中的每个Socket一次
                for (Socket socket : MyServer.socketList) {
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    ps.println(content);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 定义读取客户端数据的方法
     * */
    private String readFromClient() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {//如果捕获异常,则表明该Socket对应的客户端已关闭
            //删除该Socket
            MyServer.socketList.remove(socket);
        }
        return null;
    }
}
