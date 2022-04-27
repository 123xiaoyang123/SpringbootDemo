package com.example.pojo.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws Exception{

        Socket socket=new Socket("127.0.0.1",20000);

        new Thread(new ClientThread(socket)).start();

        PrintStream ps=new PrintStream(socket.getOutputStream());

        String line=null;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while ((line=br.readLine())!=null){
            ps.println(line);
        }
    }
}
