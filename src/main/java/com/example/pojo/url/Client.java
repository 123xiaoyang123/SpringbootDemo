package com.example.pojo.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{

//        Socket socket=new Socket("127.0.0.1",50000);
//
//        socket.setSoTimeout(10000);

        //创建一个无连接的Socket
        Socket socket=new Socket();
        //让该Socket连接到远程服务器,如果时间超过10s还没连接上,则认为连接超时
        socket.connect(new InetSocketAddress("127.0.0.1", 50000),10000);

        BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("读取到来自服务器的数据:\t"+reader.readLine());

        reader.close();
        socket.close();
    }
}
