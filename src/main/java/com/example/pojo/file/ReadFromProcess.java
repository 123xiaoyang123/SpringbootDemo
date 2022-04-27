package com.example.pojo.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadFromProcess {
    public static void main(String[] args) throws IOException {
        //运行javac命令,返回运行该命令的子进程
        Process ps = Runtime.getRuntime().exec("javac");
        try {
            //以ps进程的错误流创建BufferedReader对象
            //这个错误流对本线程是输入流,对ps进程则是输出流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ps.getErrorStream()));
            String line = null;
            //采取循环方式来读取ps进程的错误输出
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
